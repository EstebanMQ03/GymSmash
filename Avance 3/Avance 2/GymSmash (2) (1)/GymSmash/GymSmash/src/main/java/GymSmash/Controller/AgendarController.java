package GymSmash.Controller;

import GymSmash.Model.Agendar;
import GymSmash.Repository.AgendarRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AgendarController {

    @Autowired
    private AgendarRepository agendarRepository;

    @PostMapping("/agendar/guardar")
    public String guardarAgendar(
            @RequestParam("id") Long idClase,
            @RequestParam("nombre") String nombre,
            @RequestParam("descripcion") String descripcion,
            @RequestParam("fecha") String fecha,
            @RequestParam("hora") String hora,
            HttpSession session) {

        Integer usuarioId = (Integer) session.getAttribute("usuarioId");
        if (usuarioId == null) {
            return "redirect:/login";
        }

        Agendar agendar = new Agendar();
        agendar.setIdUsuario(usuarioId); // Se guarda el usuario actual
        agendar.setIdClase(idClase.intValue());
        agendar.setNombre(nombre);
        agendar.setDescripcion(descripcion);
        agendar.setFecha(fecha);
        agendar.setHora(hora);

        agendarRepository.save(agendar);

        return "redirect:/menu";
    }
}
