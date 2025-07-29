package GymSmash.Controller;

import GymSmash.Model.Usuario;
import GymSmash.Model.Clase;
import GymSmash.Repository.UsuarioRepository;
import GymSmash.Repository.ClaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MenuController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ClaseRepository claseRepository;

    @GetMapping("/menu")
    public String showMenu() {
        return "Menu";
    }

    @GetMapping("/inicio-fragment")
    public String showInicioFragment() {
        return "fragments/inicio-fragment :: content";
    }

    @GetMapping("/perfil-fragment")
    public String showPerfilFragment(HttpSession session, Model model) {
        Integer usuarioId = (Integer) session.getAttribute("usuarioId");

        if (usuarioId == null) {
            return "redirect:/login";
        }

        Usuario usuario = usuarioRepository.findById(usuarioId).orElse(null);

        if (usuario == null) {
            return "redirect:/login";
        }

        model.addAttribute("usuario", usuario);
        return "fragments/perfil-fragment :: content";
    }

    @GetMapping("/clase-fragment")
    public String showClaseFragment(Model model) {
        model.addAttribute("clases", claseRepository.findAll());
        return "fragments/clase-fragment :: content";
    }

    @GetMapping("/rutina-fragment")
    public String showRutinaFragment() {
        return "fragments/rutina-fragment :: content";
    }

    @GetMapping("/entrenador-fragment")
    public String showEntrenadorFragment() {
        return "fragments/entrenador-fragment :: content";
    }

    @GetMapping("/expediente-fragment")
    public String showExpedienteFragment() {
        return "fragments/expediente-fragment :: content";
    }

    @GetMapping("/agendar-fragment")
    public String showAgendarFragment(
            @RequestParam Long id,
            @RequestParam String nombre,
            @RequestParam String descripcion,
            HttpSession session,
            Model model) {

        Integer usuarioId = (Integer) session.getAttribute("usuarioId");
        if (usuarioId == null) {
            return "redirect:/login";
        }

        model.addAttribute("id", id);
        model.addAttribute("usuarioId", usuarioId);
        model.addAttribute("nombre", nombre);
        model.addAttribute("descripcion", descripcion);
        return "fragments/agendar-fragment :: content";
    }

    @GetMapping("/plan-fragment")
    public String showPlanFragment(@RequestParam int dia, Model model) {
        model.addAttribute("dia", dia);
        return "fragments/plan-fragment :: content";
    }

}
