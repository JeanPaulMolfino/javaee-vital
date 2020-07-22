package com.mycompany.master.resources;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import controller.controller_paciente;
import controller.controller_vemec;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author
 */
@Path("master_javaee8")
public class JavaEE8Resource {

    @GET
    public Response ping() {
        return Response
                .ok("ping")
                .build();
    }

    /*@GET
    @Path("/ping")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listallvemecs() {
        Gson convertir = new GsonBuilder().setPrettyPrinting().create();
        String resultado = convertir.toJson("pong");
        return Response
                .ok("ping")
                .entity(resultado)
                .build();
    }*/
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
    @Path("/listallvemecsbysala")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listallvemecs(
            @QueryParam("idsala") int idsala
    ) {
        Gson convertir = new GsonBuilder().setPrettyPrinting().create();
        String resultado = convertir.toJson(controller_vemec.getInstance().read_vemecbysala(idsala));
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
            @QueryParam("modelo") String modelo) {
        controller_vemec.getInstance().update_vemec(idVemec, marca, modelo);
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
    @Produces(MediaType.APPLICATION_JSON)
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
    @Produces(MediaType.APPLICATION_JSON)
    public Response read_vemecdata(
            @QueryParam("id") String id) {
        Gson convertir = new GsonBuilder().setPrettyPrinting().create();
        String resultado = convertir.toJson(controller_vemec.getInstance().read_vemecdata(id));
        return Response
                .ok("ping")
                .entity(resultado)
                .build();
    }

    @GET
    @Path("/read_deptos")
    @Produces(MediaType.APPLICATION_JSON)
    public Response read_deptos() {
        Gson convertir = new GsonBuilder().setPrettyPrinting().create();
        String resultado = convertir.toJson(controller_vemec.getInstance().read_deptos());
        return Response
                .ok("ping")
                .entity(resultado)
                .build();
    }

    @GET
    @Path("/read_categoriapordepto")
    @Produces(MediaType.APPLICATION_JSON)
    public Response read_categoriapordepto(
            @QueryParam("id") int iddepto) {
        Gson convertir = new GsonBuilder().setPrettyPrinting().create();
        String resultado = convertir.toJson(controller_vemec.getInstance().read_categorias(iddepto));
        return Response
                .ok("ping")
                .entity(resultado)
                .build();
    }

    @GET
    @Path("/personaporvemec")
    @Produces(MediaType.APPLICATION_JSON)
    public Response personaporvemec(
            @QueryParam("id") int idvemec) {
        Gson convertir = new GsonBuilder().setPrettyPrinting().create();
        String resultado = convertir.toJson(controller_vemec.getInstance().read_personaporvemec(idvemec));
        return Response
                .ok("ping")
                .entity(resultado)
                .build();
    }

    @GET
    @Path("/read_pacientessinvemecs")
    @Produces(MediaType.APPLICATION_JSON)
    public Response pacientessinvemecs() {
        Gson convertir = new GsonBuilder().setPrettyPrinting().create();
        String resultado = convertir.toJson(controller_vemec.getInstance().read_pacientessinvemecs());
        return Response
                .ok("ping")
                .entity(resultado)
                .build();
    }

    @GET
    @Path("/update_asignarvemec")
    @Produces(MediaType.APPLICATION_JSON)
    public Response personaporvemec(
            @QueryParam("idpaciente") int idpaciente,
            @QueryParam("idvemec") int idvemec) {
        controller_vemec.getInstance().update_asignarvemec(idpaciente, idvemec);
        return Response
                .ok("ping")
                .entity(null)
                .build();
    }

    @GET
    @Path("/listfullallvemecs")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listfullallvemecs() {
        Gson convertir = new GsonBuilder().setPrettyPrinting().create();
        String resultado = convertir.toJson(controller_vemec.getInstance().read_fullvemec());
        return Response
                .ok("ping")
                .entity(resultado)
                .build();
    }

    @GET
    @Path("/updatenivelriesgo")
    public Response updatenivelriesgo(
            @QueryParam("idpaciente") int idpaciente,
            @QueryParam("nivel") String nivel) {
        controller_vemec.getInstance().update_riesgopaciente(idpaciente, nivel);
        return Response
                .ok("ping")
                .entity(null)
                .build();
    }

    @GET
    @Path("/createlog")
    public Response createLog(
            @QueryParam("idpaciente") int idpaciente,
            @QueryParam("categoria") String categoria,
            @QueryParam("descripcion") String descripcion) {
        controller_paciente.getInstance().create_log(idpaciente, categoria, descripcion);
        return Response
                .ok("ping")
                .entity(null)
                .build();
    }

    @GET
    @Path("/list_logbypaciente")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listlogbypaciente(
            @QueryParam("idpaciente") int idpaciente) {
        Gson convertir = new GsonBuilder().setPrettyPrinting().create();
        String resultado = convertir.toJson(controller_paciente.getInstance().list_logsbypaciente(idpaciente));
        return Response
                .ok("ping")
                .entity(resultado)
                .build();
    }
}
