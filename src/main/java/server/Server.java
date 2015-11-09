package server;

import com.sun.jersey.api.container.grizzly2.GrizzlyServerFactory;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;
import org.glassfish.grizzly.http.server.HttpServer;

import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.net.URI;

public class Server {


    /**
     * Private method to get the the base url format 'http://localhost:8080'
     * @return
     */
    private static URI getBaseURI() {
        return UriBuilder.fromUri("http://localhost/").port(8080).build();
    }

    public static final URI BASE_URI = getBaseURI();

    /**
     * Protected method for starting the grizzly server
     * @return
     * @throws IOException
     */
    protected static HttpServer startServer() throws IOException {
        System.out.println("Starting grizzly...");
        ResourceConfig rc = new PackagesResourceConfig("com.resources");
        return GrizzlyServerFactory.createHttpServer(BASE_URI, rc);
    }

    /**
     * Public method to create a Grizzly HTTP server listening on 'http://localhost:8080'
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        HttpServer httpServer = startServer();
        System.in.read();
        httpServer.stop();
    }


}
