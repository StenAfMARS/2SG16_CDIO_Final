package API;

import DTO.LoginDTO;
import DTO.UserDTO;
import Function.IUserDAO;
import Function.SaveInDatabase;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("login")
public class LoginAPI {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public UserDTO Login(LoginDTO user){
        IUserDAO users = new SaveInDatabase();

        return users.getUser(user.getUserID());
    }
}