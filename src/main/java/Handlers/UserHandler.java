package Handlers;

import DTO.UserDTO;
import Exceptions.DALException;
import Interfaces.IUserDAO;

import java.sql.*;
import java.util.*;
import java.util.List;

public class UserHandler implements IUserDAO {

    @Override
    public UserDTO getUser(int userID){

        UserDTO userDTO = null;

        try {
            // CONNECT
            Connection connection = DatabaseHandler.connect();

            // Set statement
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM Users WHERE userID = ?");

            // Set variables
            statement.setInt(1, userID);

            // Read reply
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {
                userDTO = new UserDTO(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6).split(" ")
                );
            }

            // close things
            connection.close();
            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DALException("Couldn't find user");
        }

        // return result
        return userDTO;
    }

    @Override
    public List<UserDTO> getUserList(){

        List<UserDTO> users = new LinkedList<>();

        try {
            // CONNECT
            Connection connection = DatabaseHandler.connect();

            // Set statement
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT userID,userName,userPassword,ini,cpr,fk_RollID FROM Users");

            // Set variables

            // Read reply
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {
                users.add(new UserDTO(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6).split(" ")
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
        return users;
    }

    @Override
    public void createUser(UserDTO userDTO){
        try {
            // CONNECT
            Connection connection = DatabaseHandler.connect();

            // Set statement
            PreparedStatement statement = connection.prepareStatement(
                    "insert into Users (userName, userPassword, ini, cpr, Rolls) values (?, ?, ?, ?, ?)");

            // Set variables
            statement.setString(1, userDTO.getUserName());
            statement.setString(2, userDTO.getPassword());
            statement.setString(3, userDTO.getIni());
            statement.setString(4, userDTO.getCpr());
            if (userDTO.getRoles() == null)
                statement.setString(5, "");
            else
                statement.setString(5, String.join(" ", userDTO.getRoles()));

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
    public void updateUser(UserDTO userDTO){
        try {
            // CONNECT
            Connection connection = DatabaseHandler.connect();

            // Set statement
            PreparedStatement statement = connection.prepareStatement(
                    "update Users set userName = ?, userPassword = ?,ini = ?, cpr = ?, Rolls = ? where userId = ?");

            // Set variables
            statement.setString(1, userDTO.getUserName());
            statement.setString(2, userDTO.getPassword());
            statement.setString(3, userDTO.getIni());
            statement.setString(4, userDTO.getCpr());
            statement.setString(5, String.join(" ", userDTO.getRoles()));
            statement.setInt(6, userDTO.getUserID());

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

    @Override
    public void deleteUser(int userID){

        UserDTO userDTO = null;

        try {
            // CONNECT
            Connection connection = DatabaseHandler.connect();

            // Set statement
            PreparedStatement statement = connection.prepareStatement(
                    "delete from Users where userID = ?");

            // Set variables
            statement.setInt(1, userID);

            // Read reply
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
