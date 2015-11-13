
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.net.httpserver.HttpServer;
import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;

/**
 * Created by daniela.domnici on 13/11/15.
 */

public class Post {
        @Test
        public void addNewEmployee() throws IOException {
            HttpServer server = HttpServerFactory.create("http://localhost:8080/");
            server.start();

            Client client = Client.create();
            WebResource webResource = client.resource("http://localhost:8080/api/post/test");
            String input = "{\"name\":\"Dany\"}";
            ClientResponse response = webResource.type("application/json").post(ClientResponse.class, input);
            String output = response.getEntity(String.class);
            System.out.println(output);
            Assert.assertEquals("Input: {\"name\":\"Dany\"}", output);
            server.stop(0);
        }
}

