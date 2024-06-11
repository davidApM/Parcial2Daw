
package libcode.appweb.controladores;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.util.ArrayList;
import java.util.List;
import libcode.appweb.entidades.Materia;
import libcode.appweb.negocio.DataService;

@Named
//solo recibe peticiones 
@RequestScoped
public class IndexControllerMateria {
    
    private List<Materia> materiasList = new ArrayList<>();
    private Materia materia = new Materia();
    
    @EJB
    DataService servicio;
    
    @PostConstruct
    public void cargarMaterias() {
       materiasList = servicio.getMaterias();
    }
    
    public void guardarMateria() {
        if (materia.getId() != null) {
            servicio.editMateria(materia);
        } else {
            servicio.saveMateria(materia);
        }
        materia = new Materia();
        cargarMaterias();
    }

    public void llenarFormEditarMateria(Materia materia) {
        this.materia.setId(materia.getId());
        this.materia.setNombreMateria(materia.getNombreMateria());
        this.materia.setCodigoMateria(materia.getCodigoMateria());
        this.materia.setDescripcionMateria(materia.getDescripcionMateria()); 
    }

    public void eliminarMateria(Materia materia) {
        servicio.deleteMateria(materia);
        cargarMaterias();
    }


    //Get y set 
    public List<Materia> getMateriasList() {
        return materiasList;
    }

    public void setMateriasList(List<Materia> materiasList) {
        this.materiasList = materiasList;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }
    
}
