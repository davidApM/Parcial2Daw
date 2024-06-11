
package libcode.appweb.entidades;

import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name ="Inscripciones" )
public class Inscripcion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inscripciones_id_seq")
    @SequenceGenerator(name = "inscripciones_id_seq", sequenceName="inscripciones_id_seq", allocationSize=1) //para generar 
    @Column(name="id")
    private Integer id;
    
    @ManyToOne
    @JoinColumn(name = "alumnoId")
    private Alumno alumno;
    
    @ManyToOne
    @JoinColumn(name = "materiaId")
    private Materia materia;
    
    @Column(name = "ciclo")
    private String ciclo;
    
    @Column(name = "anio")
    private Integer anio;
    
    @JsonbDateFormat("yyyy-MM-dd")
    @Column(name = "fechaInscripcion")
     private LocalDate fechaInscripcion;
    
    //Get y set 

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public Integer  getAnio() {
        return anio;
    }

    public void setAnio(Integer  anio) {
        this.anio = anio;
    }

    public LocalDate getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(LocalDate fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    //Contructores

    public Inscripcion() {
        this.alumno = new Alumno();
        this.materia = new Materia();
    }

    public Inscripcion(Integer id) {
        this.id = id;
    }
    

    public Inscripcion(Integer id, Alumno alumno, Materia materia) {
        this.id = id;
        this.alumno = alumno;
        this.materia = materia;
    }

    public Inscripcion(Integer id, Alumno alumno, Materia materia, String ciclo, Integer anio, LocalDate fechaInscripcion) {
        this.id = id;
        this.alumno = alumno;
        this.materia = materia;
        this.ciclo = ciclo;
        this.anio = anio;
        this.fechaInscripcion = fechaInscripcion;
    }

    


     
}
