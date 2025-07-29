package GymSmash.Controller;

import GymSmash.Model.Usuario;
import GymSmash.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegistroController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/registro")
    public String showRegistro() {
        return "Registro";
    }

    @PostMapping("/registro")
    public String registrarUsuario(
            @RequestParam String nombre,
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam int edad) {

        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setUsername(username);
        usuario.setPassword(password);
        usuario.setEdad(edad);

        usuarioRepository.save(usuario);

        return "redirect:/login";
    }
}
