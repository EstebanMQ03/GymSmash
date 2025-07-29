package GymSmash.Repository;

import GymSmash.Model.Expediente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpedienteRepository extends JpaRepository<Expediente, Integer> {
    Expediente findByUsuarioId(Integer usuarioId);
}
