package com.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Created by daniela.domnici on 06/11/15.
 */
@Path("/employee")
public class Test {
        // The Java method will process HTTP GET requests
        @GET
        // The Java method will produce content identified by the MIME Media
        // type "text/plain"
        @Produces("text/plain")
        public String getClichedMessage() {
            // Return some cliched textual content
            return "Hello World";
        }

    }
