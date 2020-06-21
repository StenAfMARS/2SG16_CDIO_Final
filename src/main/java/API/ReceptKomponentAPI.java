package API;

import DTO.UserDTO;
import Handlers.UserHandler;
import Interfaces.IUserDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("receptKomponent")
public class ReceptKomponentAPI {
    private static IUserDAO users;
    public static IUserDAO Users(){
        if (users == null)
            users = new UserHandler();
        return users;
    }

    @Path("{id : [0-9]+}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public static UserDTO get(@PathParam("id") int userID){
        return Users().getUser(userID);
    }

    @Path("{id : [0-9]+}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public static void update(UserDTO user){
        Users().updateUser(user);
    }

    @Path("{id : [0-9]+}")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public static void delete(@PathParam("id") int userID){
        Users().deleteUser(userID);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public static void create(UserDTO user){
        Users().createUser(user);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public static List<UserDTO> getList(){
        return Users().getUserList();
    }

}
