
package libcode.appweb.resources;

import jakarta.ejb.EJB;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import libcode.appweb.entidades.Inscripcion;
import libcode.appweb.negocio.DataService;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/inscripciones")
public class RecursoInscripcion {
    @EJB
    private DataService servicio;

    @POST
    public Response saveInscripciones(Inscripcion inscripciones){
        servicio.saveInscripcion(inscripciones);
        return Response.ok("Inscripción creada exitosamente ").build();
    }

    @GET
    public Response getInscripciones() {
        List<Inscripcion> inscripciones = servicio.getInscripciones();
        return Response.ok(inscripciones).build();
    }
    
    
    @PUT
    public Response editInscripciones(Inscripcion inscripciones){
        servicio.editInscripcion(inscripciones);
        return Response.ok("Inscripción editada exitosamente ").build();
    }
    
    @DELETE
    @Path("/{id}")
    public Response deleteInscripciones(@PathParam("id") Integer id){
        servicio.deleteInscripcion(new Inscripcion(id));
        return Response.ok("Inscripcion eliminada exitosamente ").build();
    }

}
