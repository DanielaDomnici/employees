package com.resource;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.Employee;

/**
 * Created by daniela.domnici on 09/11/15.
 */
@Path("/api")
public class Api {

    @GET
    @Path("/test/get")
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("text/plain")
    public String getClichedMessage() {
        // Return some cliched textual content
        return "Hello World";
    }

    @GET
    @Path("/get")
    // The Java method will produce content identified by the MIME Media type "application/json"
    @Produces("application/json")
    public Employee GetCreatedEmployee() {
        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("MihaiPppescu");
        employee.setCnp("1882704069887");
        employee.setBirthDate("27 04 1988");
        return employee;
    }

    @GET
    // The Java method will produce content identified by the MIME Media type "application/json"
    @Path("/get/{id}")
    @Produces("application/json")
    public Employee GetCreatedEmployee(@PathParam("id") int id) {
        Employee employee = new Employee();
        employee.setId(id);
        employee.setName("MihaiPppescu");
        employee.setCnp("1882704069887");
        employee.setBirthDate("27 04 1988");
        return employee;
    }

    @POST
    // The Java method will produce/consume content identified by the MIME Media type "application/json"
    @Path("/post")
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createEmployeeInJSON(Employee employee) {
        String result = "Employee saved : " + employee;
        return Response.status(201).entity(result).build();
    }

    @POST
    // The Java method will produce/consume content identified by the MIME Media type "application/json"
    @Path("test/post")
    @Produces("application/json")
    @Consumes("application/json")
    public String createPost() {
        String post = "Created Post!";
        return post;
    }

    @PUT
    // The Java method will produce/consume content identified by the MIME Media type "application/json"
    @Path("/update")
    @Produces("application/json")
    @Consumes("application/json")
    public Employee updateEmployee(Employee employee){
        employee.setName(employee.getName() + "employee updated");
        return employee;
    }


}
