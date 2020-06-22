package API;

import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/rest")
public class AppConfig extends Application {

    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet<>();
        resources.add(APITest.class);
        resources.add(ProduktBatchAPI.class);
        resources.add(RaavareAPI.class);
        resources.add(RaavareBatchAPI.class);
        resources.add(ReceptAPI.class);
        resources.add(UserAPI.class);
        return resources;
    }
}
