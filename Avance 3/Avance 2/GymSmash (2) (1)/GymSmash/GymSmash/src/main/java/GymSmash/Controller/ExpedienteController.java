package GymSmash.Controller;

import GymSmash.Model.Expediente;
import GymSmash.Repository.ExpedienteRepository;
import GymSmash.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ExpedienteController {

    @Autowired
    private ExpedienteRepository expedienteRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/expediente")
    public String seleccionarUsuario(Model model) {
        model.addAttribute("usuarios", usuarioRepository.findAll());
        return "Expediente";
    }

    @GetMapping("/expediente/ver")
    public String verExpediente(@RequestParam Integer usuarioId, Model model) {
        model.addAttribute("usuarios", usuarioRepository.findAll());
        Expediente expediente = expedienteRepository.findByUsuarioId(usuarioId);
        model.addAttribute("expediente", expediente);
        return "Expediente";
    }
}
