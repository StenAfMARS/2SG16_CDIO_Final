package API;

import DTO.LoginDTO;
import DTO.UserDTO;
import Interfaces.IUserDAO;
import Handlers.UserHandler;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("login")
public class LoginAPI {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public UserDTO Login(LoginDTO user){
        IUserDAO users = new UserHandler();

        return users.getUser(user.getUserID());
    }
}