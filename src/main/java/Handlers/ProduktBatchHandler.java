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
                    "SELECT * FROM produktBatch WHERE  pbID=?");

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
                    "insert into produktBatch (status, receptID) values ( ?, ?)");

            // Set variables
            statement.setInt(1, produktbatch.getStatus());
            statement.setInt(2, produktbatch.getReceptID());

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
                    "update produktBatch set pbID = ?, status = ?,fk_receptID = ? where pbID = ?");

            // Set variables
            statement.setInt(1, produktbatch.getPbID());
            statement.setInt(2, produktbatch.getStatus());
            statement.setInt(3, produktbatch.getReceptID());
            statement.setInt(4, produktbatch.getPbID());




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
                    "delete from produktBatch where pbID = ?");

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
                    "SELECT * FROM productBatchComponents WHERE  fk_UserID=?");

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
                    "SELECT * FROM productBatchComponents");

            // Set variables

            // Read reply
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {
                ProduktBatchKompDTOs.add(new ProduktBatchKompDTO(
                        resultSet.getInt(5),
                        resultSet.getInt(2),
                        resultSet.getDouble(3),
                        resultSet.getDouble(4),
                        resultSet.getInt(1)));
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

    public ProduktBatchKompDTO getproduktBatchKompDTO(int pbID, int rbID) throws DALException {

        ProduktBatchKompDTO ProduktBatchKompDTO = null;

        try {
            // CONNECT
            Connection connection = DatabaseHandler.connect();

            // Set statement
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM productBatchComponents where pbID = ? and rbID = ?");

            // Set variables
            statement.setInt(1, pbID);
            statement.setInt(2, rbID);

            // Read reply
            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()) {
                ProduktBatchKompDTO = new ProduktBatchKompDTO(
                        resultSet.getInt(5),
                        resultSet.getInt(2),
                        resultSet.getDouble(3),
                        resultSet.getDouble(4),
                        resultSet.getInt(1));
            }

            // close things
            connection.close();
            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        // return result

        return ProduktBatchKompDTO;
    }


    public void createProduktBatchKompDTO(ProduktBatchKompDTO produktBatchKompDTO) throws DALException {
        try {
            // CONNECT
            Connection connection = DatabaseHandler.connect();

            // Set statement
            PreparedStatement statement = connection.prepareStatement(
                    "insert into productBatchComponents (fk_UserID, fk_rbID, tara, netto, fk_pbID) values (?, ?, ?, ?, ?)");


            // Set variables


            statement.setInt(1, produktBatchKompDTO.getOprID());
            statement.setInt(2, produktBatchKompDTO.getRbID());
            statement.setDouble(3, produktBatchKompDTO.getTara());
            statement.setDouble(4, produktBatchKompDTO.getNetto());
            statement.setInt(5, produktBatchKompDTO.getPbID());

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
                    "update productBatchComponents set tara = ?, netto= ? where fk_rbID = ? AND fk_pbID=?");

            // Set variables


            statement.setDouble(1, produktBatchKomp.getTara());
            statement.setDouble(2, produktBatchKomp.getNetto());
            statement.setInt(3, produktBatchKomp.getRbID());
            statement.setInt(4, produktBatchKomp.getPbID());

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


