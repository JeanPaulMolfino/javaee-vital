package com.mycompany.webservice.resources;

import clases.vemec;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import controller.controller_paciente;
import controller.controller_vemec;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author
 */
@Path("javaee8")
public class JavaEE8Resource {

    @GET
    public Response ping() {
        return Response
                .ok("ping")
                .build();
    }

    @GET
    @Path("/listallvemecs")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listallvemecs() {
        Gson convertir = new GsonBuilder().setPrettyPrinting().create();
        String resultado = convertir.toJson(controller_vemec.getInstance().read_vemec());
        return Response
                .ok("ping")
                .entity(resultado)
                .build();
    }
    
    @GET
    @Path("/vemecspaciente")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listvemecsynombre() {
        Gson convertir = new GsonBuilder().setPrettyPrinting().create();
        String resultado = convertir.toJson(controller_vemec.getInstance().read_vemec2());
        return Response
                .ok("ping")
                .entity(resultado)
                .build();
    }

    @GET
    @Path("/createvemec")
    public Response createVemec(
            @QueryParam("marca") String marca,
            @QueryParam("modelo") String modelo,
            @QueryParam("ubicacion") String ubicacion) {
        controller_vemec.getInstance().create_vemec(marca, modelo, ubicacion);
        return Response
                .ok("ping")
                .entity(null)
                .build();
    }

    @GET
    @Path("/updatevemec")
    public Response updateVemec(
            @QueryParam("idVemec") String idVemec,
            @QueryParam("marca") String marca,
            @QueryParam("modelo") String modelo,
            @QueryParam("ubicacion") String ubicacion) {
        controller_vemec.getInstance().update_vemec(idVemec, marca, modelo, ubicacion);
        return Response
                .ok("ping")
                .entity(null)
                .build();
    }

    @GET
    @Path("/deletevemec")
    public Response deleteVemec(
            @QueryParam("idVemec") String idVemec
    ) {
        controller_vemec.getInstance().delete_vemec(idVemec);
        return Response
                .ok("ping")
                .entity(null)
                .build();
    }

    @GET
    @Path("/createpaciente")
    public Response createPaciente(
            @QueryParam("ci") String ci,
            @QueryParam("nombre") String nombre,
            @QueryParam("apellido") String apellido,
            @QueryParam("edad") String edad) {
        controller_paciente.getInstance().create_pacientes(ci, nombre, apellido, edad);
        return Response
                .ok("ping")
                .entity(null)
                .build();
    }
    
    @GET
    @Path("/read_vemecdata_3minutes")
    public Response read_vemecdata_3minutes(
            @QueryParam("id") String id) {
        Gson convertir = new GsonBuilder().setPrettyPrinting().create();
        String resultado = convertir.toJson(controller_vemec.getInstance().read_vemecdata_3minutes(id));
        return Response
                .ok("ping")
                .entity(resultado)
                .build();
    }
    
    @GET
    @Path("/read_vemecdata")
    public Response read_vemecdata(
            @QueryParam("id") String id) {
        Gson convertir = new GsonBuilder().setPrettyPrinting().create();
        String resultado = convertir.toJson(controller_vemec.getInstance().read_vemecdata(id));
        return Response
                .ok("ping")
                .entity(resultado)
                .build();
    }
    
}
