package GymSmash.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MenuController {

    @RequestMapping("/")
    public String Inicio(Model model) {
        return "Inicio";
    }

    @RequestMapping("/registro")
    public String Registro(Model model) {
        return "Registro";
    }

    @RequestMapping("/Menu")
    public String Menu(Model model) {
        return "Menu";
    }

    @RequestMapping("/perfil")
    public String Perfil(Model model) {
        return "Perfil";
    }

    @RequestMapping("/clase")
    public String Clase(Model model) {
        return "Clase";
    }

    @RequestMapping("/rutina")
    public String Rutina(Model model) {
        return "Rutina";
    }

    @RequestMapping("/entrenador")
    public String Entrenador(Model model) {
        return "Entrenador";
    }

    @RequestMapping("/expediente")
    public String Expediente(Model model) {
        return "Expediente";
    }

}
