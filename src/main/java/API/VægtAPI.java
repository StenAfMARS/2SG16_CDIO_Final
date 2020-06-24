package API;

import DTO.ProduktBatchKompDTO;
import DTO.ReceptKomponentDTO;
import Handlers.ProduktBatchHandler;
import Handlers.VægtHandler;
import com.mysql.cj.xdevapi.Session;
import jdk.nashorn.internal.objects.annotations.Getter;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import java.sql.SQLException;

@Path("afvejning")
public class VægtAPI {

    @GET
    @Path("{id : [0-9]+}")
    @Produces(MediaType.APPLICATION_JSON)
    public static ReceptKomponentDTO nextComponent(@PathParam("id") int pbID){
        return null;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public static Response produktBatchesDerSkalLaves(){
        ProduktBatchHandler pbHandler = new ProduktBatchHandler();
        ResponseBuilder response = Response.noContent();

        try {
            response.entity(pbHandler.getProduktBatchListOfUnfinishedProducts());
        } catch (SQLException e) {
            response.status(500);
            e.printStackTrace();
        }

        return response.build();
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
