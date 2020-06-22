package API;

import DTO.RaavareBatchDTO;
import Exceptions.DALException;
import Handlers.RaavareBatchHandler;
import Interfaces.IRaavareBatchHandler;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("raavareBatches")
public class RaavareBatchAPI {
    private static IRaavareBatchHandler raavareBatches;
    public static IRaavareBatchHandler RaavareBatches(){
        if (raavareBatches == null)
            raavareBatches = new RaavareBatchHandler();
        return raavareBatches;
    }

    @Path("{id : [0-9]+}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public static RaavareBatchDTO get(@PathParam("id") int raavareBatchID){
        return RaavareBatches().getRaavareBatch(raavareBatchID);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public static Response update(RaavareBatchDTO raavareBatch){
        try {
            RaavareBatches().updateRaavareBatch(raavareBatch);
        } catch (DALException e) {
            e.printStackTrace();

            return Response.status(418).build();
        }

        return Response.status(201).build();
    }

    @Path("{id : [0-9]+}")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public static Response delete(@PathParam("id") int raavareBatchID){
        //RaavareBatchs().de(raavareBatchID);
        return Response.status(418).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public static Response create(RaavareBatchDTO raavareBatch){
    try {
        RaavareBatches().createRaavareBatch(raavareBatch);
    } catch (DALException e){
        e.printStackTrace();

        return Response.status(418).build();
        }

        return Response.status(201).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public static List<RaavareBatchDTO> getList(){
        return RaavareBatches().getRaavareBatchList();
    }
}
