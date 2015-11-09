package com.resource;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.Employee;
import com.QualityAssurance;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by daniela.domnici on 09/11/15.
 */
@Path("/api")
public class Api {

    Employee em1 = new Employee(1, "PopMarian", "20 august 1987", "1872008039961");
    QualityAssurance em2 = new QualityAssurance(2, "PopescuIoan", "18 mai 1990", "1901805039961", 3);

    @GET
    @Produces("application/json")
    public Response CreateEmployee() throws JSONException {

        JSONObject jsonObject = new JSONObject();

        jsonObject.put("employee1", em1);
        jsonObject.put("employee2", em2);

        JSONArray array = new JSONArray();
        array.put(jsonObject);

        String result = "@Produces(\"application/json\") Output: \n\nEmployee added: \n\n" + jsonObject;
        return Response.status(201).entity(result).build();
    }
}
