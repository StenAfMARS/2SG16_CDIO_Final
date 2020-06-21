package Handlers;

import DTO.RaavareDTO;
import Exceptions.DALException;
import Interfaces.IRaavareHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class RaavareHandler implements IRaavareHandler {
    @Override
    public RaavareDTO getRaavare(int raavareId) throws DALException {

        RaavareDTO RaavareDTO = null;

        try {
            // CONNECT
            Connection connection = DatabaseHandler.connect();

            // Set statement
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM Raavare WHERE RaavareID = ?");

            // Set variables
            statement.setInt(1, raavareId);

            // Read reply
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {
                RaavareDTO = new RaavareDTO(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3)
                );
            }

            // close things
            connection.close();
            resultSet.close();
            statement.close();

        } catch ( SQLException e) {
            e.printStackTrace();
            throw new DALException("Couldn't find user");
        }

        // return result
        return RaavareDTO ;
    }

    @Override
    public List<RaavareDTO> getRaavareList() throws DALException {
        List<RaavareDTO> raavare = new LinkedList<>();

        try {
            // CONNECT
            Connection connection = DatabaseHandler.connect();

            // Set statement
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM Raavare");

            // Set variables

            // Read reply
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {
                raavare.add(new RaavareDTO(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3)
                ));
            }

            // close things
            connection.close();
            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        // return result
        return raavare;
    }

    @Override
    public void createRaavare(RaavareDTO RaavareDTO) throws DALException {
        try {
            // CONNECT
            Connection connection = DatabaseHandler.connect();

            // Set statement
            PreparedStatement statement = connection.prepareStatement(
                    "insert into Raavare (RaavareNavn, leverandoer) values (?, ?)");

            // Set variables
            statement.setString(1, RaavareDTO.getRaavareNavn());
            statement.setString(2, RaavareDTO.getLeverandoer());
            // Excecute
            statement.execute();

            // close things
            connection.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DALException("Couldn't find user");
        }
    }

    @Override
    public void updateRaavare(RaavareDTO raavareDTO) throws DALException {
        try {
            // CONNECT
            Connection connection = DatabaseHandler.connect();

            // Set statement
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE Raavare SET RaavareNavn = ?, leverandoer = ? WHERE RaavareID = ?");

            // Set variables
            statement.setString(1, raavareDTO.getRaavareNavn());
            statement.setString(2, raavareDTO.getLeverandoer());
            // Execute
            statement.execute();

            // close things
            connection.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DALException("Couldn't find user");
        }
    }
}
