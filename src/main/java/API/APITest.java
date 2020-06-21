package API;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("COFFEE")
public class APITest {

    @POST
    public Response IAmGoingToBeATeapot(){
        return Response.status(418).build();
    }

    @PUT
    public Response IWillAlwaysBeBeATeapot(){
        return Response.status(418).build();
    }

    @DELETE
    public Response IWasATeapot(){
        return Response.status(418).build();
    }

    @GET
    public Response IAmATeapot(){
        return Response.status(418).build();
    }
}
