package Handlers;

import DTO.ProduktBatchDTO;
import DTO.RaavareBatchDTO;
import Exceptions.DALException;
import Interfaces.IRaavareBatchHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class RaavareBatchHandler implements IRaavareBatchHandler {
    @Override
    public RaavareBatchDTO getRaavareBatch(int RaavareBatchId) throws DALException {
        RaavareBatchDTO raavareBatchDTO= null;


        try {
            // CONNECT
            Connection connection = DatabaseHandler.connect();

            // Set statement
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM raavareBatch WHERE  rbId=?");

            // Set variables
            statement.setInt(1, RaavareBatchId);

            // Read reply
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {
                raavareBatchDTO = new RaavareBatchDTO(
                        resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getInt(3));
            }

            // close things
            connection.close();
            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DALException("Couldn't find commodity");
        }

        // return result
        return raavareBatchDTO;

    }

    @Override
    public List<RaavareBatchDTO> getRaavareBatchList() throws DALException {


        List<RaavareBatchDTO> raavareBatchDTOS = new LinkedList<>();

        try {
            // CONNECT
            Connection connection = DatabaseHandler.connect();

            // Set statement
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM raavareBatch");

            // Set variables

            // Read reply
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {
                raavareBatchDTOS.add(new RaavareBatchDTO(
                        resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getInt(3)));
            }

            // close things
            connection.close();
            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        // return result

        return raavareBatchDTOS;
    }

    @Override
    public List<RaavareBatchDTO> getRaavareBatchList(int raavareId) throws DALException {
        return null;
    }

    @Override
    public void createRaavareBatch(RaavareBatchDTO raavarebatch) throws DALException {
        try{
            Connection connection = DatabaseHandler.connect();

            PreparedStatement statement = connection.prepareStatement(
                    "insert into raavarebatch (rdId, maengde, raavareID) values (?, ?, ?)");

            statement.setDouble(1,raavarebatch.getMaengde());
            statement.setInt(2,raavarebatch.getRaavareId());
            statement.execute();

            connection.close();
            statement.close();

        }catch (SQLException e){
            e.printStackTrace();
            throw new DALException("Couldn't find commodity");
        }
    }

    @Override
    public void updateRaavareBatch(RaavareBatchDTO raavarebatch) throws DALException {
        try {
            // CONNECT
            Connection connection = DatabaseHandler.connect();

            // Set statement
            PreparedStatement statement = connection.prepareStatement(
                    "update raavarebatch set rdId = ?, maengde = ?,raavareID = ? where rdId = ?");
            // Set variables


            statement.setInt(1, raavarebatch.getRbId());
            statement.setDouble(2, raavarebatch.getMaengde());
            statement.setInt(3, raavarebatch.getRaavareId());




            // Execute
            statement.execute();

            // close things
            connection.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DALException("Couldn't find commodity");
        }

    }
}