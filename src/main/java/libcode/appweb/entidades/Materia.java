
package libcode.appweb.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "materia")
public class Materia  implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "materia_id_seq")
    @SequenceGenerator(name = "materia_id_seq", sequenceName="materia_id_seq", allocationSize=1) //para generar 
    @Column(name="materiaId")
     private Integer id;
    @Column(name="nombreMateria")
     private String nombreMateria;
    @Column(name="descripcionMateria")
     private String descripcionMateria;
    @Column(name="codigoMateria")
     private String codigoMateria; 
    
    @OneToMany(mappedBy = "materia")
    private List<Inscripcion> inscripciones = new ArrayList<>();

    //Get y Set 
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public String getDescripcionMateria() {
        return descripcionMateria;
    }

    public void setDescripcionMateria(String descripcionMateria) {
        this.descripcionMateria = descripcionMateria;
    }

    public String getCodigoMateria() {
        return codigoMateria;
    }

    public void setCodigoMateria(String codigoMateria) {
        this.codigoMateria = codigoMateria;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Materia other = (Materia) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Materia{" + "id=" + id + ", nombreMateria=" + nombreMateria + ", descripcion=" + descripcionMateria + ", codigoMateria=" + codigoMateria + '}';
    }
    
    //Contructores

    public Materia() {
        
    }
    
    public Materia(Integer id) {
        this.id = id;
    }
    
     public Materia(Integer id, String nombreMateria) {
        this.id = id;
        this.nombreMateria = nombreMateria;
    }

    public Materia(Integer id, String nombreMateria, String descripcionMateria, String codigoMateria) {
        this.id = id;
        this.nombreMateria = nombreMateria;
        this.descripcionMateria = descripcionMateria;
        this.codigoMateria = codigoMateria;
    }


    
}
