package API;

import DTO.ProduktBatchKompDTO;
import DTO.ReceptKomponentDTO;
import Exceptions.DALException;
import Handlers.ProduktBatchHandler;
import Handlers.ReceptHandler;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("ReceptComponents")
public class ReceptComponentsAPI {
    private static ReceptHandler receptComponents;
    public static ReceptHandler receptComponents(){
        if (receptComponents == null)
            receptComponents = new ReceptHandler();
        return receptComponents;
    }

    @Path("{id : [0-9]+}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public static List<ReceptKomponentDTO> get(@PathParam("id") int ReceptID){
        return receptComponents().getReceptKomponentList();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public static List<ReceptKomponentDTO> getList()
    {
        return receptComponents().getReceptKomponentList();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public static Response update(ReceptKomponentDTO receptKomponents){
        try {
            receptComponents().updateReceptKomponent(receptKomponents);
        } catch (DALException e) {
            e.printStackTrace();

            return Response.status(418).build();
        }

        return Response.status(201).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public static Response create(ReceptKomponentDTO receptKomponents){
        try {
            receptComponents().createReceptKomponent(receptKomponents);
        } catch (DALException e){
            e.printStackTrace();

            return Response.status(418).build();
        }

        return Response.status(201).build();
    }

}
