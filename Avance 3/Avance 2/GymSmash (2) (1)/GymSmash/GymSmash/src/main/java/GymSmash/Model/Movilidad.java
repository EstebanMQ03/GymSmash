package GymSmash.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "movilidad")
public class Movilidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", length = 150, nullable = false)
    private String nombre;

    @Column(name = "reps", length = 50, nullable = false)
    private String reps;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dia", nullable = false)
    private Rutina rutina;

    //  Constructores 

    public Movilidad() {
    }

    public Movilidad(String nombre, String reps, Rutina rutina) {
        this.nombre = nombre;
        this.reps = reps;
        this.rutina = rutina;
    }

    //  Getters y Setters 

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

    public String getReps() {
        return reps;
    }

    public void setReps(String reps) {
        this.reps = reps;
    }

    public Rutina getRutina() {
        return rutina;
    }

    public void setRutina(Rutina rutina) {
        this.rutina = rutina;
    }
}
