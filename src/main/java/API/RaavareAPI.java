package API;

import DTO.RaavareDTO;
import Exceptions.DALException;
import Handlers.RaavareHandler;
import Interfaces.IRaavareHandler;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("raavarer")
public class RaavareAPI {
    private static IRaavareHandler raavare;
    public static IRaavareHandler Raavare(){
        if (raavare == null)
            raavare = new RaavareHandler();
        return raavare;
    }

    @Path("{id : [0-9]+}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public static RaavareDTO get(@PathParam("id") int raavareID){
        return Raavare().getRaavare(raavareID);
    }

    @Path("{id : [0-9]+}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public static Response update(RaavareDTO raavare){
        try {
            Raavare().updateRaavare(raavare);
        } catch (DALException e){
            e.printStackTrace();

            return Response.status(418).build();
        }

        return Response.status(201).build();
    }

    @Path("{id : [0-9]+}")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public static Response delete(@PathParam("id") int raavareID){
        //Raavare().(raavareID);
        return Response.status(418).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public static Response create(RaavareDTO raavare){
        try {
            Raavare().createRaavare(raavare);
        } catch (DALException e){
            e.printStackTrace();

            return Response.status(418).build();
        }

        return Response.status(201).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public static List<RaavareDTO> getList(){
        return Raavare().getRaavareList();
    }

}
