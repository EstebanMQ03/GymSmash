package GymSmash.Model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "rutina")
public class Rutina {

    @Id
    @Column(name = "dia")
    private Integer dia;  //  Integer porque es clave primaria pero no autoincremental

    @Column(name = "id_entrenador")
    private Long idEntrenador;  // FK a entrenador, puede ser null

    @Column(name = "entrenador", length = 100, nullable = false)
    private String entrenador = "no asignado";  // Valor por defecto

    @Column(name = "musculos", length = 150, nullable = false)
    private String musculos;

    @OneToMany(mappedBy = "rutina", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Movilidad> movilidad = new ArrayList<>();

    @OneToMany(mappedBy = "rutina", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ejercicio> ejercicios = new ArrayList<>();

    //  Constructores 

    public Rutina() {
    }

    public Rutina(Integer dia, Long idEntrenador, String entrenador, String musculos) {
        this.dia = dia;
        this.idEntrenador = idEntrenador;
        this.entrenador = entrenador;
        this.musculos = musculos;
    }

    // ======== Getters y Setters ========

    public Integer getDia() {
        return dia;
    }

    public void setDia(Integer dia) {
        this.dia = dia;
    }

    public Long getIdEntrenador() {
        return idEntrenador;
    }

    public void setIdEntrenador(Long idEntrenador) {
        this.idEntrenador = idEntrenador;
    }

    public String getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(String entrenador) {
        this.entrenador = entrenador;
    }

    public String getMusculos() {
        return musculos;
    }

    public void setMusculos(String musculos) {
        this.musculos = musculos;
    }

    public List<Movilidad> getMovilidad() {
        return movilidad;
    }

    public void setMovilidad(List<Movilidad> movilidad) {
        this.movilidad = movilidad;
    }

    public List<Ejercicio> getEjercicios() {
        return ejercicios;
    }

    public void setEjercicios(List<Ejercicio> ejercicios) {
        this.ejercicios = ejercicios;
    }
}
