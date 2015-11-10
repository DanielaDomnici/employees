package com.resource;

import javax.ws.rs.*;
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
    private int id = 1;
    private String name ="MihaiPppescu";
    private String cnp = "1882704069887";
    private String birthday = "27 04 1988";

    @GET
    @Produces("application/json")
    public Response GetCreatedEmployee() throws JSONException {
        Employee em1 = new Employee();
        em1.setId(id);
        em1.setName(name);
        em1.setCnp(cnp);
        em1.setBirthDate(birthday);

        JSONArray array = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", id);
        jsonObject.put("name", name);
        jsonObject.put("cnp", cnp);
        jsonObject.put("birthday", birthday);

        array.put(jsonObject);

        String result = "Output: \n\nEmployee added: \n\n" + jsonObject;
        return Response.status(201).entity(result).build();
    }
}
