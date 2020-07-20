package com.mycompany.master.resources;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author 
 */
@Path("master_javaee8")
public class JavaEE8Resource {
    
    @GET
    public Response ping(){
        return Response
                .ok("ping")
                .build();
    }
    
    @GET
    @Path("/ping")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listallvemecs() {
        Gson convertir = new GsonBuilder().setPrettyPrinting().create();
        String resultado = convertir.toJson("pong");
        return Response
                .ok("ping")
                .entity(resultado)
                .build();
    }
}
