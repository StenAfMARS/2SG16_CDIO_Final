package Handlers;

import DTO.ProduktBatchKompDTO;
import DTO.ReceptKomponentDTO;
import Exceptions.DALException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VægtHandler {

    public List<ReceptKomponentDTO> getReceptID(int id)throws DALException, SQLException{
        List<ReceptKomponentDTO> commodetyList = new ArrayList<>();
        try{
            Connection connection = DatabaseHandler.connect();

            PreparedStatement statement = connection.prepareStatement(
                    "SELECT produktBatch.fk_receptID, fk_raavareID, nonNetto, tolerance\n" +
                            "FROM produktBatch\n" +
                            "join productBatchComponents on pbID = fk_pbID\n" +
                            "join RecebtComponents on produktBatch.fk_ReceptID = RecebtComponents.fk_ReceptID\n" +
                            "where pbID = ? and \n" +
                            "fk_raavareID not in\n" +
                            "(SELECT fk_raavareID\n" +
                            "FROM produktBatch\n" +
                            "join productBatchComponents on pbID = fk_pbID\n" +
                            "join raavareBatch on fk_rbID = rbID\n" +
                            "where pbID = ?)");

            statement.setInt(1, id);
            statement.setInt(2, id);
            statement.execute();

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                commodetyList.add(new ReceptKomponentDTO(
                        resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getDouble(3),
                        resultSet.getDouble(4)));
            }


            connection.close();
            resultSet.close();
            statement.close();

        }catch (SQLException e){
            e.printStackTrace();
            throw new DALException("Could not find recept component");
        }

        return commodetyList;
    }
    public void afmaalt(int laborantID, int pbID, int rbID, double mTara, double mNetto) throws DALException {
        ProduktBatchHandler pbHandler = new ProduktBatchHandler();
        ReceptHandler receptHandler = new ReceptHandler();
        RaavareBatchHandler rbHandler = new RaavareBatchHandler();

        int receptID = pbHandler.getProduktBatch(pbID).getReceptID();
        int raavareID = rbHandler.getRaavareBatch(rbID).getRaavareID();

        System.out.println(receptID);
        System.out.println(rbID);
        System.out.println(raavareID);

        ReceptKomponentDTO receptKomponent = receptHandler.getReceptKomponent(receptID, raavareID);

        System.out.println(receptKomponent);

        double nonNetto = receptKomponent.getNonNetto();    // Vægt mål
        double tolerance = receptKomponent.getTolerance();   // Tolerance i procent

        if ((100 - tolerance)/100 * nonNetto < mNetto
                && mNetto < (100 + tolerance)/100 * nonNetto){

            new ProduktBatchHandler().createProduktBatchKompDTO(
                    new ProduktBatchKompDTO(pbID, rbID, mTara, mNetto, laborantID)
            );
        } else {
            throw new DALException("Incorrect weight");
        }
    }
}
