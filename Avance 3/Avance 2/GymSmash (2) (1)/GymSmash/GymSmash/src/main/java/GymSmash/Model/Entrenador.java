package GymSmash.Model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "entrenador")
public class Entrenador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(length = 100)
    private String especialidad;

    @OneToMany(mappedBy = "entrenador", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Rutina> rutinas;

    //  CONSTRUCTORES 

    public Entrenador() {
    }

    public Entrenador(String nombre, String especialidad) {
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    //  GETTERS Y SETTERS 

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public List<Rutina> getRutinas() {
        return rutinas;
    }

    public void setRutinas(List<Rutina> rutinas) {
        this.rutinas = rutinas;
    }
}
