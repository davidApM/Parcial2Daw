package libcode.appweb.controladores;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.util.ArrayList;
import java.util.List;
import libcode.appweb.entidades.Alumno;
import libcode.appweb.entidades.Inscripcion;
import libcode.appweb.entidades.Materia;
import libcode.appweb.negocio.DataService;

@Named
//solo recibe peticiones 
@RequestScoped
public class IndexControllerInscripcion {

    private List<Inscripcion> inscripcionesList = new ArrayList<>();
    private Inscripcion inscripcion = new Inscripcion();
    private List<Alumno> alumnos = new ArrayList<>(); // Lista de alumnos
     private List<Materia> materias = new ArrayList<>(); // Lista de materias

    @EJB
    DataService servicio;

    @PostConstruct
    public void cargarInscripciones() {
        inscripcionesList = servicio.getInscripciones();
        alumnos = servicio.getAlumnos();
        materias = servicio.getMaterias();
        // Verificar si inscripcion es null y crear una nueva instancia si es así
        if (inscripcion == null) {
            inscripcion = new Inscripcion();
        }

    }

    public void guardarInscripcion() {
        if (inscripcion == null) {
            inscripcion = new Inscripcion();
        }

        // Obtener el alumno y la materia seleccionados
        Alumno alumno = servicio.findAlumnoById(inscripcion.getAlumno().getId());
        Materia materia = servicio.findMateriaById(inscripcion.getMateria().getId());

        // Verificar que alumno y materia no sean nulos antes de guardar
        if (alumno == null || materia == null) {
            // Manejar el caso en el que alumno o materia sean nulos
            // Podrías mostrar un mensaje de error, lanzar una excepción, etc.
            return;
        }

        inscripcion.setAlumno(alumno);
        inscripcion.setMateria(materia);

        if (inscripcion.getId() != null) {
            servicio.editInscripcion(inscripcion);
        } else {
            servicio.saveInscripcion(inscripcion);
        }

        inscripcion = new Inscripcion();
        cargarInscripciones();
    }



    public void eliminarInscripcion(Inscripcion inscripcion) {
        if (inscripcion != null) {
            servicio.deleteInscripcion(inscripcion);
            cargarInscripciones();
        }
    }

    public void llenarFormEditarIncripcion(Inscripcion inscripcion) {
        this.inscripcion.setId(inscripcion.getId());
        this.inscripcion.getAlumno().getNombre();
        this.inscripcion.getMateria().getNombreMateria();
        this.inscripcion.setCiclo(inscripcion.getCiclo());
        this.inscripcion.setAnio(inscripcion.getAnio());
        this.inscripcion.setFechaInscripcion(inscripcion.getFechaInscripcion());
    }

    public List<Inscripcion> getInscripcionesList() {
        return inscripcionesList;
    }

    public void setInscripcionesList(List<Inscripcion> inscripcionesList) {
        this.inscripcionesList = inscripcionesList;
    }

    public Inscripcion getInscripcion() {
        return inscripcion;
    }

    public void setInscripcion(Inscripcion inscripcion) {
        this.inscripcion = inscripcion;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
    }
    
    

}
