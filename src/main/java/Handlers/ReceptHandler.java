/*
 * Peter M. Skaarup
 * 21/05-2020
*/
package Handlers;

import DTO.ReceptDTO;
import DTO.ReceptKomponentDTO;
import Exceptions.DALException;
import Interfaces.IReceptHandler;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class ReceptHandler implements IReceptHandler {


    @Override
    public ReceptDTO getRecept(int ReceptID) throws DALException {

        ReceptDTO receptDTO = null;

        try {
            Connection connection = DatabaseHandler.connect();

            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM Recept WHERE ReceptID = ?");

            statement.setInt(1, ReceptID);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                receptDTO = new ReceptDTO(
                        resultSet.getInt("ReceptID"),
                        resultSet.getString("receptNavn")
                );
            }

            connection.close();
            resultSet.close();
            statement.close();


        }catch (SQLException e) {
            e.printStackTrace();
            throw new DALException("Couldn't find recept");
        }

        return receptDTO;
    }

    @Override
    public List<ReceptDTO> getReceptList() throws DALException {

        List<ReceptDTO> receptList = new LinkedList<>();

        try{

            Connection connection = DatabaseHandler.connect();

            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM Recept");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                receptList.add(new ReceptDTO(
                        resultSet.getInt("ReceptID"),
                        resultSet.getString("receptNavn")
                ));
            }

            connection.close();
            resultSet.close();
            statement.close();

        }catch (SQLException e){

            e.printStackTrace();
        }

        return receptList;
    }

    @Override
    public void createRecept(ReceptDTO recept) throws DALException {

        try{
            Connection connection = DatabaseHandler.connect();

            PreparedStatement statement = connection.prepareStatement(
                    "insert into Recept (receptId, receptNavn) values (?, ?)");

            statement.setInt(1,recept.getReceptID());
            statement.setString(2,recept.getReceptNavn());

            statement.execute();

            connection.close();
            statement.close();

        }catch (SQLException e){
            e.printStackTrace();
            throw new DALException("Couldn't find recept");
        }
    }

    @Override
    public void updateRecept(ReceptDTO recept) throws DALException {

        try{
            Connection connection = DatabaseHandler.connect();

            PreparedStatement statement = connection.prepareStatement(
                    "update Recept set receptNavn = ? where ReceptId = ?");

            statement.setString(1, recept.getReceptNavn());
            statement.setInt(2, recept.getReceptID());

            statement.execute();




            connection.close();
            statement.close();

        }catch (SQLException e){
            e.printStackTrace();
            throw new DALException("Couldn't find recept");
        }

    }

    @Override
    public ReceptKomponentDTO getReceptKomponent(int receptID, int raavareID) throws DALException {

        ReceptKomponentDTO ReceptKomponentDTO = null;

        try{
            Connection connection = DatabaseHandler.connect();
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM RecebtComponents WHERE fk_ReceptID = ? AND fk_RaavareID = ?");

            statement.setInt(1, receptID);
            statement.setInt(2, raavareID);

            statement.execute();

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                ReceptKomponentDTO = new ReceptKomponentDTO(
                        resultSet.getInt("fk_RaavareID"),
                        resultSet.getInt("nonNetto"),
                        resultSet.getInt("tolerance"),
                        resultSet.getInt("fk_ReceptID")
                );
            }

            connection.close();
            statement.close();



        }catch (SQLException e){
            e.printStackTrace();
            throw new DALException("Could not find RaavareID and/or ReceptID");
        }

        return null;
    }

    @Override
    public List<ReceptKomponentDTO> getReceptKomponentList() throws DALException {
        return null;
    }

    @Override
    public void createReceptKomponent(ReceptKomponentDTO receptkomponent) throws DALException {

    }

    @Override
    public void updateReceptKomponent(ReceptKomponentDTO receptKomponent) throws DALException {

    }
}
