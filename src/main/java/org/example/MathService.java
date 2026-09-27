package org.example;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/math")
@Produces(MediaType.APPLICATION_JSON)
public class MathService {

    private MathManager manager;

    // Conectamos el servicio web
    public MathService() {
        this.manager = MathManagerImpl.getInstance();
    }

    @POST
    @Path("/requerir")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response requerirOperacion(Operacion op) {
        manager.requerirOperacion(op.getIdAlumno(), op.getIdInstituto(), op.getExpresion());
        return Response.status(201).entity("Operacion encolada correctamente").build();
    }

    @PUT
    @Path("/procesar")
    public Response procesar() {
        Operacion op = manager.procesarOperacion();
        if (op == null) {
            return Response.status(404).entity("No hay operaciones pendientes en la cola").build();
        }
        return Response.ok(op).build();
    }

    @GET
    @Path("/instituto/{id}")
    public Response getByInstituto(@PathParam("id") String id) {
        List<Operacion> lista = manager.listarOperacionesInstituto(id);
        return Response.ok(lista).build();
    }

    @GET
    @Path("/alumno/{id}")
    public Response getByAlumno(@PathParam("id") String id) {
        List<Operacion> lista = manager.listarOperacionesAlumno(id);
        return Response.ok(lista).build();
    }

    @GET
    @Path("/institutos")
    public Response getInstitutosOrdenados() {
        List<Instituto> lista = manager.listarInstitutosOrdenados();
        return Response.ok(lista).build();
    }
}