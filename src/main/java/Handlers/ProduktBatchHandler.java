package Handlers;

import DTO.ProduktBatchDTO;
import DTO.ProduktBatchKompDTO;
import Exceptions.DALException;
import Interfaces.IProduktBatchHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ProduktBatchHandler implements IProduktBatchHandler {
    @Override
    public ProduktBatchDTO getProduktBatch(int produktbatch) throws DALException {
        ProduktBatchDTO produktBatchDTO= null;


        try {
            // CONNECT
            Connection connection = DatabaseHandler.connect();

            // Set statement
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM produktBatch WHERE  pbId=?");

            // Set variables
            statement.setInt(1, produktbatch);

            // Read reply
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {
                produktBatchDTO = new ProduktBatchDTO(
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
            throw new DALException("Couldn't find product");
        }

        // return result
        return produktBatchDTO;
    }

    @Override
    public List<ProduktBatchDTO> getProduktBatchList() throws DALException {

        List<ProduktBatchDTO> products = new LinkedList<>();

        try {
            // CONNECT
            Connection connection = DatabaseHandler.connect();

            // Set statement
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM produktBatch");

            // Set variables

            // Read reply
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {
                products.add(new ProduktBatchDTO(
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



        return products;
    }

    @Override
    public void createProduktBatch(ProduktBatchDTO produktbatch) throws DALException {

        try {
            // CONNECT
            Connection connection = DatabaseHandler.connect();

            // Set statement
            PreparedStatement statement = connection.prepareStatement(
                    "insert into Produktbatch ( status, ReceptID) values ( ?, ?)");


            // Set variables


            statement.setInt(1, produktbatch.getStatus());
            statement.setInt(2, produktbatch.getReceptId());




            // Excecute
            statement.execute();

            // close things
            connection.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DALException("Couldn't find product");
        }

    }

    @Override
    public void updateProduktBatch(ProduktBatchDTO produktbatch) throws DALException {

        try {
            // CONNECT
            Connection connection = DatabaseHandler.connect();

            // Set statement
            PreparedStatement statement = connection.prepareStatement(
                    "update Produktbatch set pdId = ?, status = ?,ReceptID = ? where pdId = ?");

            // Set variables


            statement.setInt(1, produktbatch.getStatus());
            statement.setInt(2, produktbatch.getReceptId());




            // Execute
            statement.execute();

            // close things
            connection.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DALException("Couldn't find product");
        }

    }

    @Override
    public void deleteProduktBatch(int produktbatch) throws DALException {
        ProduktBatchDTO produktBatchDTO= null;

        try {
            // CONNECT
            Connection connection = DatabaseHandler.connect();

            // Set statement
            PreparedStatement statement = connection.prepareStatement(
                    "delete from Produktbatch where pdId = ?");

            // Set variables
            statement.setInt(1, produktbatch);

            // Read reply
            statement.execute();

            // close things
            connection.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DALException("Couldn't find product");
        }

    }
    public ProduktBatchKompDTO getproduktBatchKompDTO(int produktBatchKomp) throws DALException {

        ProduktBatchKompDTO produktBatchKompDTO= null;
        try {
            // CONNECT
            Connection connection = DatabaseHandler.connect();

            // Set statement
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM produktBatchComponents WHERE  UserID=?");

            // Set variables
            statement.setInt(1, produktBatchKomp);

            // Read reply
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {
                produktBatchKompDTO = new ProduktBatchKompDTO(
                        resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getDouble(3),
                        resultSet.getDouble(4),
                        resultSet.getInt(5));
            }

            // close things
            connection.close();
            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DALException("Couldn't find productKom");
        }

        // return result
        return produktBatchKompDTO;
    }


    public List<ProduktBatchKompDTO> getproduktBatchKompDTOList() throws DALException {

        List<ProduktBatchKompDTO> ProduktBatchKompDTOs = new LinkedList<>();

        try {
            // CONNECT
            Connection connection = DatabaseHandler.connect();

            // Set statement
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM produktBatchComponents");

            // Set variables

            // Read reply
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {
                ProduktBatchKompDTOs.add(new ProduktBatchKompDTO(
                        resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getDouble(3),
                        resultSet.getDouble(4),
                        resultSet.getInt(5)));
            }

            // close things
            connection.close();
            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        // return result

        return ProduktBatchKompDTOs;
    }


    public void createProduktBatchKompDTO(ProduktBatchKompDTO produktBatchKompDTO) throws DALException {
        try {
            // CONNECT
            Connection connection = DatabaseHandler.connect();

            // Set statement
            PreparedStatement statement = connection.prepareStatement(
                    "insert into produktBatchComponents (UserID, raavareBatch, tara, netto, pdId) values (?, ?, ?, ?, ?)");


            // Set variables


            statement.setInt(1, produktBatchKompDTO.getRbId());
            statement.setDouble(2, produktBatchKompDTO.getTara());
            statement.setDouble(3, produktBatchKompDTO.getNetto());
            statement.setInt(4, produktBatchKompDTO.getPbId());





            // Excecute
            statement.execute();

            // close things
            connection.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DALException("Couldn't find productkom");
        }
    }


    public void updateProduktBatchKompDTO(ProduktBatchKompDTO produktBatchKomp) throws DALException {


        try {
            // CONNECT
            Connection connection = DatabaseHandler.connect();

            // Set statement
            PreparedStatement statement = connection.prepareStatement(
                    "update produktBatchComponents set UserID = ?, raavareBatch = ?,tara = ?, netto= ?,pdId=? where UserID = ?");

            // Set variables


            statement.setInt(1, produktBatchKomp.getOprId());
            statement.setInt(2, produktBatchKomp.getRbId());
            statement.setDouble(3, produktBatchKomp.getTara());
            statement.setDouble(4, produktBatchKomp.getNetto());
            statement.setInt(5, produktBatchKomp.getPbId());


            // Execute
            statement.execute();

            // close things
            connection.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DALException("Couldn't find productKom");
        }
    }
}


