package GymSmash.Controller;

import GymSmash.Model.Usuario;
import GymSmash.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/login")
    public String showLogin(@RequestParam(value = "error", required = false) String error, Model model) {
        if (error != null) {
            model.addAttribute("error", "Credenciales incorrectas");
        }
        return "Inicio"; 
    }

    @PostMapping("/login")
    public String login(
            @RequestParam String username,
            @RequestParam String password,
            HttpSession session,
            Model model) {

        Usuario usuario = usuarioRepository.findByUsernameAndPassword(username, password);

        if (usuario != null) {
            // Guardamos el usuario en la sesión
            session.setAttribute("usuarioId", usuario.getId());
            session.setAttribute("usuarioNombre", usuario.getNombre()); 

            return "redirect:/menu";
        } else {
            model.addAttribute("error", "Credenciales incorrectas");
            return "Inicio";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // ✅ Borra la sesión
        return "redirect:/login";
    }
}
