package com.resource;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.Employee;
import com.EmployeeDao;
import com.QualityAssurance;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.awt.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by daniela.domnici on 09/11/15.
 */
@Path("/api")
public class Api {

    @GET
    @Path("/get")
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
    @Path("/post")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createEmployeeInJSON(Employee employee) {
        String result = "Employee saved : " + employee;
        return Response.status(201).entity(result).build();
    }
}
