package API;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("login")
public class LoginAPI {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String Login(LoginAPI username){
        return "You are logged in as " + username;
    }
}