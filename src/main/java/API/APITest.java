package API;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("test")
public class APITest {

    @POST
    public String stringTest(){
        return "test";
    }
}
