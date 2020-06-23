package API;

import DTO.ProduktBatchKompDTO;
import Exceptions.DALException;
import Handlers.ProduktBatchHandler;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("productBatchKomponents")
public class ProduktBatchComponentAPI {
    private static ProduktBatchHandler produktBatches;
    public static ProduktBatchHandler ProduktBatches(){
        if (produktBatches == null)
            produktBatches = new ProduktBatchHandler();
        return produktBatches;
    }

    @Path("{id : [0-9]+}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public static ProduktBatchKompDTO get(@PathParam("id") int produktBatchID){
        return ProduktBatches().getproduktBatchKompDTO(produktBatchID);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public static Response update(ProduktBatchKompDTO produktBatch){
        try {
            ProduktBatches().updateProduktBatchKompDTO(produktBatch);
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
        return Response.status(418).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public static Response create(ProduktBatchKompDTO produktBatch){
        try {
            ProduktBatches().createProduktBatchKompDTO(produktBatch);
        } catch (DALException e){
            e.printStackTrace();

            return Response.status(418).build();
        }

        return Response.status(201).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public static List<ProduktBatchKompDTO> getList(){
        return ProduktBatches().getproduktBatchKompDTOList();
    }
}
