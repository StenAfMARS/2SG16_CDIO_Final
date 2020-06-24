package API;

import DTO.ProduktBatchKompDTO;
import DTO.ReceptKomponentDTO;
import Exceptions.DALException;
import Handlers.ProduktBatchHandler;
import Handlers.VægtHandler;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.sql.SQLException;

@Path("afvejning")
public class VægtAPI {

    @GET
    @Path("{id : [0-9]+}")
    @Produces(MediaType.APPLICATION_JSON)
    public static ReceptKomponentDTO nextComponent(@Context HttpServletResponse response, @PathParam("id") int pbID) throws IOException {
        VægtHandler vægtHandler = new VægtHandler();

        try {
            ReceptKomponentDTO s = vægtHandler.getReceptID(pbID).get(0);
            if (s == null)
                throw new NullPointerException();
            return s;
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(500);
        }

        return null;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public static Integer[] produktBatchesDerSkalLaves(@Context HttpServletResponse response) throws IOException {
        ProduktBatchHandler pbHandler = new ProduktBatchHandler();

        try {
            return pbHandler.getProduktBatchListOfUnfinishedProducts();
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(500);
        }

        response.sendError(400);
        return null;
    }

    @POST
    @Path("{id : [0-9]+}")
    @Consumes(MediaType.APPLICATION_JSON)
    public static Response nextCoponent(@PathParam("id") int userID, ProduktBatchKompDTO produktBatchKompDTO){
        VægtHandler vægtHandler = new VægtHandler();

        try {
            vægtHandler.afmaalt(userID, produktBatchKompDTO.getPbID(), produktBatchKompDTO.getRbID(), produktBatchKompDTO.getTara(), produktBatchKompDTO.getNetto());
        } catch (DALException e){
            e.printStackTrace();
            Response.status(400);
        }

        return Response.status(201).build();
    }

}
