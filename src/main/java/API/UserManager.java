package API;

import Data.UserDTO;
import Function.IUserDAO;
import Function.SaveInDatabase;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("user")
public class UserManager{
    private static IUserDAO users;
    public static IUserDAO Users(){
        if (users == null)
            users = new SaveInDatabase();
        return users;
    }

    @Path("getUser")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public static UserDTO get(UserDTO user){
        return Users().getUser(user.getUserID());
    }

    @Path("getUserList")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public static List<UserDTO> getList(){
        return Users().getUserList();
    }

    @Path("updateUser")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public static void update(UserDTO user){
        Users().updateUser(user);
    }

    @Path("deleteUser")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public static void delete(UserDTO user){
        Users().deleteUser(user.getUserID());
    }

    @Path("createUser")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public static void create(UserDTO user){
        Users().createUser(user);
    }
}
