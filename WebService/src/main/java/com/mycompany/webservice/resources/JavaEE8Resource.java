package com.mycompany.webservice.resources;

import clases.vemec;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import controller.controller_vemec;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author 
 */
@Path("javaee8")
public class JavaEE8Resource {
    @GET
    public Response ping(){
        return Response
                .ok("ping")
                .build();
    }
    
    @GET
    @Path("/listallvemecs")
    @Produces(MediaType.APPLICATION_JSON)
    public Response test(){
        List<vemec> result = controller_vemec.getInstance().read_vemec();
        Gson convertir = new GsonBuilder().setPrettyPrinting().create();
        String resultado = convertir.toJson(result);
        return Response
                .ok("ping")
                .entity(resultado)
                .build();
    }
    
}
