package API;

import DTO.ReceptDTO;
import Exceptions.DALException;
import Handlers.ReceptHandler;
import Interfaces.IReceptHandler;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("recepter")
public class ReceptAPI {
    private static IReceptHandler recepts;
    public static IReceptHandler Recepts(){
        if (recepts == null)
            recepts = new ReceptHandler();
        return recepts;
    }

    @Path("{id : [0-9]+}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public static ReceptDTO get(@PathParam("id") int receptID){
        return Recepts().getRecept(receptID);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public static Response update(ReceptDTO recept){
        try {
            Recepts().updateRecept(recept);
        } catch (DALException e){
            e.printStackTrace();

            return Response.status(418).build();
        }

        return Response.status(201).build();
    }

    @Path("{id : [0-9]+}")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public static Response delete(@PathParam("id") int receptID){
        //Recepts().(recept);
        return Response.status(418).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public static Response create(ReceptDTO recept){
        try {
            Recepts().createRecept(recept);
        } catch (DALException e){
            e.printStackTrace();

            return Response.status(418).build();
        }

        return Response.status(201).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public static List<ReceptDTO> getList(){
        return Recepts().getReceptList();
    }
}
