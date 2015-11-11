import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by daniela.domnici on 11/11/15.
 */
public class Demo {

    @Test
    public void testGetEmployee() {
        Client client = Client.create();

        WebResource resource = client.resource("http://localhost:8080/rest/myApplication/api/get");

        ClientResponse response = resource.accept("application/json").get(ClientResponse.class);

        if (response.getStatus() != 200){
            throw  new RuntimeException("Request failed!");
        }


        String output = response.getEntity(String.class);
        Assert.assertEquals("{\"birthday\":\"27 04 1988\",\"cnp\":\"1882704069887\",\"name\":\"MihaiPppescu\",\"id\":1}", output);
    }

    @Test
    public void testPost(){
        Client client = Client.create();

        WebResource webResource = client.resource("http://localhost:8080/rest/myApplication/api/post");

        String input = "{\"birthday\":\"27 04 1988\",\"cnp\":\"1882704069887\",\"name\":\"MihaiPppescu\",\"id\":1}";

        ClientResponse response = webResource.type("application/json").post(ClientResponse.class, input);

        if (response.getStatus() != 201) {
            throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
        }

        String output = response.getEntity(String.class);
        System.out.println(output);
    }
}



