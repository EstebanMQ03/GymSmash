package GymSmash.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String mostrarInicio() {
        return "Inicio"; // Pantalla tradicional
    }

    @GetMapping("/Menu")
    public String mostrarMenu() {
        return "Menu";
    }

    @GetMapping("/Registro")
    public String mostrarRegistro() {
        return "Registro";
    }

    @GetMapping("/Perfil")
    public String mostrarPerfil() {
        return "Perfil";
    }

    @GetMapping("/Clase")
    public String mostrarClase() {
        return "Clase";
    }

    @GetMapping("/Rutina")
    public String mostrarRutina() {
        return "Rutina";
    }

    @GetMapping("/Entrenador")
    public String mostrarEntrenador() {
        return "Entrenador";
    }

    @GetMapping("/Expediente")
    public String mostrarExpediente() {
        return "Expediente";
    }
}