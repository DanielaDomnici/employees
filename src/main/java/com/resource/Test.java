package com.resource;

import org.json.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 * Created by daniela.domnici on 06/11/15.
 */
@Path("/test")
public class Test {
        // The Java method will process HTTP GET requests
       @GET
        // The Java method will produce content identified by the MIME Media
        // type "application/json"
        @Produces("application/json")
        public Response getClichedMessage() {
            JSONObject jsonObject = new JSONObject();
            String hello = "Hello";
            String kitty = "Kitty";
            jsonObject.put("Hello", hello);
            jsonObject.put("Kitty", kitty);

            String result = "Output: " + jsonObject;
            return Response.status(200).entity(result).build();
        }
}
