package GymSmash.Controller;

import GymSmash.Model.Usuario;
import GymSmash.Repository.UsuarioRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PerfilController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    //  Actualizar perfil del usuario
    @PostMapping("/perfil")
    public String actualizarPerfil(
            @RequestParam String nombre,
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam int edad,
            HttpSession session) {

        Integer usuarioId = (Integer) session.getAttribute("usuarioId");
        if (usuarioId == null) {
            return "redirect:/login";
        }

        Usuario usuario = usuarioRepository.findById(usuarioId).orElse(null);
        if (usuario == null) {
            return "redirect:/login";
        }

        usuario.setNombre(nombre);
        usuario.setUsername(username);
        usuario.setPassword(password);
        usuario.setEdad(edad);

        usuarioRepository.save(usuario);

        return "redirect:/menu"; // después de actualizar, regresa al menú
    }
}
