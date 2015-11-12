import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import com.sun.net.httpserver.HttpServer;
import org.junit.Assert;
import org.junit.Test;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

/**
 * Created by daniela.domnici on 11/11/15.
 */
public class Demo {

    @Test
    public void testGet() {
        Client client = Client.create();

        WebResource resource = client.resource("http://localhost:8080/myApplication/rest/api/test/get");

        ClientResponse response = resource.accept("text/plain").get(ClientResponse.class);

        if (response.getStatus() != 200){
            throw new RuntimeException("Request failed : " + response.getStatus());
        }

        String output = response.getEntity(String.class);
        Assert.assertEquals("Hello World", output);
    }

    @Test
    public void testPost(){
        Client client = Client.create();

        WebResource webResource = client.resource("http://localhost:8080/myApplication/rest/api/test/post");

        String input = "Created Post";

        ClientResponse response = webResource.type("application/json").post(ClientResponse.class, input);

        if (response.getStatus() != 201) {
            throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
        }

        String output = response.getEntity(String.class);
        Assert.assertEquals("Created Post!", output);
    }
}



