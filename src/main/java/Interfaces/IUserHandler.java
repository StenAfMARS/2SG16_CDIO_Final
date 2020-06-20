package Interfaces;

import DTO.UserDTO;
import Exceptions.DALException;

import java.util.List;

public interface IUserHandler {
    //oprettes brugeren i databasen
    void createUser(UserDTO user) throws DALException;

    //rettes brugeren i databasen
    void updateUser (UserDTO user) throws DALException;

    //viser brugeren
    UserDTO getUser(int userId) throws DALException;

    //slette brugeren
    void deleteUser(int userId) throws DALException;

    // viser alle brugerne i databasen
    List<UserDTO> getUserList() throws DALException;

}
