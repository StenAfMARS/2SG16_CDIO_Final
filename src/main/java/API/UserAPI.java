package API;

import DTO.UserDTO;
import Exceptions.DALException;
import Handlers.UserHandler;
import Interfaces.IUserDAO;
import Handlers.UserHandler;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("users")
public class UserAPI {
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

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public static Response update(UserDTO user){
        try {
            Users().updateUser(user);
        } catch (DALException e){
            e.printStackTrace();

            return Response.status(418).build();
        }

        return Response.status(201).entity(user).build();
    }

    @Path("{id : [0-9]+}")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public static Response delete(@PathParam("id") int userID){
        try {
            Users().deleteUser(userID);
        } catch (DALException e){
            e.printStackTrace();

            return Response.status(418).build();
        }

        return Response.status(201).entity(userID).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public static Response create(UserDTO user){
        try {
            Users().createUser(user);
        } catch (DALException e){
            e.printStackTrace();

            return Response.status(418).build();
        }

        return Response.status(201).entity(user).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public static List<UserDTO> getList(){
        return Users().getUserList();
    }
}
