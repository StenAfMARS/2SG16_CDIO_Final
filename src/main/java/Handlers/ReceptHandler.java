/*
 * Peter M. Skaarup
 * 21/05-2020
*/
package Handlers;

import DTO.ReceptDTO;
import DTO.UserDTO;
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

    }

    @Override
    public void updateRecept(ReceptDTO recept) throws DALException {

    }
}
