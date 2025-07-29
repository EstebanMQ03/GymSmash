package GymSmash.Model;

import jakarta.persistence.*;

@Entity
public class Expediente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Usuario usuario;

    private String historial;  // Ejemplo: "Lesión en rodilla, operación 2022"
    private String observaciones;

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public String getHistorial() { return historial; }
    public void setHistorial(String historial) { this.historial = historial; }

    public String getObservaciones() { return observaciones; }
    public void setObservaciones(String observaciones) { this.observaciones = observaciones; }
}
