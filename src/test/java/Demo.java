import com.base.JerseyTest;
import com.sun.jersey.api.client.WebResource;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by daniela.domnici on 09/11/15.
 */
public class Demo extends JerseyTest{
    public Demo() throws Exception {
        super("com.resource");
    }

    @Test
    public void testGetEmployee() {
        WebResource webResource = resource();
        String responseMsg = webResource.path("api").get(String.class);
        System.out.println(responseMsg);
    }
}
