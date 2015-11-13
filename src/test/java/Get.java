import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import com.sun.net.httpserver.HttpServer;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by daniela.domnici on 13/11/15.
 */
public class Get {
    @Test
    public void testGetFailed() throws IOException {
        HttpServer server = HttpServerFactory.create("http://localhost:8080/");
        server.start();

        Client client = Client.create();
        WebResource webResource = client.resource("http://localhost:8080/");
        String responseMsg = webResource.path("api").path("get").path("2").get(String.class);
        Assert.assertEquals("{\"id\":1,\"name\":\"MihaiPppescu\",\"birthDate\":\"27 04 1988\",\"cnp\":\"1882704069887\"}", responseMsg);
        server.stop(0);
    }

    @Test
    public void testGetSuccess() throws IOException {
        HttpServer server = HttpServerFactory.create("http://localhost:8080/");
        server.start();

        Client client = Client.create();
        WebResource webResource = client.resource("http://localhost:8080/");
        String responseMsg = webResource.path("api").path("get").path("1").get(String.class);
        Assert.assertEquals("{\"id\":1,\"name\":\"MihaiPppescu\",\"birthDate\":\"27 04 1988\",\"cnp\":\"1882704069887\"}", responseMsg);
        server.stop(0);
    }
}
