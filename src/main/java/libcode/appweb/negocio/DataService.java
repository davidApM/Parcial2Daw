package libcode.appweb.negocio;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.util.List;
import libcode.appweb.entidades.Alumno;
import libcode.appweb.entidades.Inscripcion;
import libcode.appweb.entidades.Materia;

@Stateless
public class DataService {
  @PersistenceContext(unitName="pu")
  EntityManager entityManager; 
  
  public List<Alumno> getAlumnos(){
      Query query = entityManager.createQuery("SELECT e FROM Alumno e ORDER BY e.id ASC");
      List<Alumno> alumnos = query.getResultList();
       return alumnos; 
  }
  
    public Alumno findAlumnoById(Integer id) {
        return entityManager.find(Alumno.class, id);
    }
  
  @Transactional
  public void saveAlumno(Alumno alumno){
      entityManager.persist(alumno);
  }
  
  @Transactional
  public void editAlumno(Alumno alumno){
      //La funcion merge sirve para modificar una entidad
      entityManager.merge(alumno); 
  }
  
  @Transactional
  public void deleteAlumno(Alumno alumno){
      //la clase o nombre de la clase, el id o llave primaria de la entidad. 
      Alumno alumnoEliminar = entityManager.find(Alumno.class, alumno.getId());
      entityManager.remove(alumnoEliminar);
  }
  
  //Metodos para la clase materia. 
  
    //Me devuelve la lista de materias que existe en la base de datos. 
    public List<Materia> getMaterias() {
        //Query en la clase materia, el e.id es el que nos va a devolver, en nuestro caso será nombre. 
        Query query = entityManager.createQuery("SELECT e FROM Materia e ORDER BY e.id ASC");
        List<Materia> materias = query.getResultList(); //Resultado de la consulta. 
        return materias;
    }
    
    public Materia findMateriaById(Integer id) {
        return entityManager.find(Materia.class, id);
    }

    //funciona para guardar un alumno. 
  @Transactional
    public void saveMateria(Materia materia) {
        entityManager.persist(materia);
    }

    //funciona para guardar un alumno. 
    @Transactional
    public void editMateria(Materia materia) {
        //La funcion merge sirve para modificar una entidad
        entityManager.merge(materia);
    }
    
    //funciona para eliminar un alumno. 
    @Transactional
    public void deleteMateria(Materia materia) {
        //Nombre de la clase, el id o llave primaria de la entidad. 
        Materia materiaEliminar = entityManager.find(Materia.class, materia.getId());
        entityManager.remove(materiaEliminar);
    }
    
    //Metodos para la clase Inscripcion
   // Métodos de Inscripcion
    
    public List<Inscripcion> getInscripciones() {
        //Query en la clase Inscripcion, el e.id es el que nos va a devolver, en nuestro caso será nombre. 
        Query query = entityManager.createQuery("SELECT e FROM Inscripcion e ORDER BY e.id ASC");
        List<Inscripcion> inscripciones = query.getResultList(); //Resultado de la consulta. 
        return inscripciones;
    }
    
    @Transactional
    public void saveInscripcion(Inscripcion inscripcion) {
        entityManager.persist(inscripcion);
    }
    
    @Transactional
    public void editInscripcion(Inscripcion inscripcion) {
        //La funcion merge sirve para modificar una entidad
        entityManager.merge(inscripcion);
    }
    
    @Transactional
    public void deleteInscripcion(Inscripcion inscripcion) {
        //Nombre de la clase, el id o llave primaria de la entidad. 
        Inscripcion inscripcionEliminar = entityManager.find(Inscripcion.class, inscripcion.getId());
        entityManager.remove(inscripcionEliminar);
    }

}
