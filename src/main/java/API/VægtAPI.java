package API;

import DTO.ProduktBatchKompDTO;
import DTO.ReceptKomponentDTO;
import Handlers.ProduktBatchHandler;
import Handlers.VægtHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import java.io.IOException;
import java.sql.SQLException;

@Path("afvejning")
public class VægtAPI {

    @GET
    @Path("{id : [0-9]+}")
    public static int nextComponent(@PathParam("id") int pbID){
        return 1;
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
    @Consumes(MediaType.APPLICATION_JSON)
    public static Response nextCoponent(@Context HttpServletRequest request, ProduktBatchKompDTO produktBatchKompDTO){
        VægtHandler vægtHandler = new VægtHandler();

        Integer userID = (Integer)request.getSession().getAttribute("sessionUserID");

        if (userID == null)
            return Response.status(401).build();

        vægtHandler.afmålt(userID, produktBatchKompDTO.getPbID(), produktBatchKompDTO.getRbID(), produktBatchKompDTO.getTara(), produktBatchKompDTO.getNetto());

        return Response.status(201).build();
    }

}
