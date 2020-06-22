package API;

import DTO.ProduktBatchDTO;
import Exceptions.DALException;
import Handlers.ProduktBatchHandler;
import Interfaces.IProduktBatchHandler;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("productBatches")
public class ProduktBatchAPI {
    private static IProduktBatchHandler produktBatches;
    public static IProduktBatchHandler ProduktBatches(){
        if (produktBatches == null)
            produktBatches = new ProduktBatchHandler();
        return produktBatches;
    }

    @Path("{id : [0-9]+}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public static ProduktBatchDTO get(@PathParam("id") int produktBatchID){
        return ProduktBatches().getProduktBatch(produktBatchID);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public static Response update(ProduktBatchDTO produktBatch){
        try {
            ProduktBatches().updateProduktBatch(produktBatch);
        } catch (DALException e) {
            e.printStackTrace();

            return Response.status(418).build();
        }

        return Response.status(201).build();
    }

    @Path("{id : [0-9]+}")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public static Response delete(@PathParam("id") int produktBatchID){
        try {
            ProduktBatches().deleteProduktBatch(produktBatchID);
        } catch (DALException e){
            e.printStackTrace();

            return Response.status(418).build();
        }

        return Response.status(201).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public static Response create(ProduktBatchDTO produktBatch){
        try {
            ProduktBatches().createProduktBatch(produktBatch);
        } catch (DALException e){
            e.printStackTrace();

            return Response.status(418).build();
        }

        return Response.status(201).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public static List<ProduktBatchDTO> getList(){
        return ProduktBatches().getProduktBatchList();
    }
}
