package API;

import DTO.ProduktBatchKompDTO;
import DTO.ReceptKomponentDTO;
import Handlers.VægtHandler;
import com.mysql.cj.xdevapi.Session;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;

@Path("afvejning")
public class VægtAPI {

    @GET
    @Path("{id : [0-9]+}")
    @Produces(MediaType.APPLICATION_JSON)
    public static ReceptKomponentDTO nextComponent(@PathParam("id") int pbID){
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
