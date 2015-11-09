import com.base.JerseyTest;
import com.sun.jersey.api.client.WebResource;
import org.junit.Assert;
import org.junit.Test;

public class Testare extends JerseyTest {

    public Testare() throws Exception {
        super("com.resource");
    }

    /**
     * Test to see that the message "Hello World" is sent in the response.
     */
    @Test
    public void testHelloWorld() {
        WebResource webResource = resource();
        String responseMsg = webResource.path("test").get(String.class);
        Assert.assertEquals("Hello World", responseMsg);
    }
}
