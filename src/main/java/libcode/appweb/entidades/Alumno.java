
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
@Table(name = "alumno")
public class Alumno implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="alumno_id_seq")
    @SequenceGenerator(name = "alumno_id_seq", sequenceName="alumno_id_seq", allocationSize=1)
    @Column(name="alumnoId")
    private Integer id;
    @Column(name="nombre")
    private String nombre;
    @Column(name="carnet")
    private String carnet; 
    
    @OneToMany(mappedBy = "alumno")
    private List<Inscripcion> inscripciones = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.id);
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
        final Alumno other = (Alumno) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Alumno{" + "id=" + id + ", nombre=" + nombre + ", carnet=" + carnet + '}';
    }

    public Alumno(Integer id) {
        this.id = id;
    }

    public Alumno(Integer id, String nombre, String carnet) {
        this.id = id;
        this.nombre = nombre;
        this.carnet = carnet;
    }
    
    public Alumno() {
       
    }

    public Alumno(String nombre, String carnet) {
        this.nombre = nombre;
        this.carnet = carnet;
    }
    
    
    
    
}
