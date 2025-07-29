package GymSmash.Repository;

import GymSmash.Model.Entrenador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntrenadorRepository extends JpaRepository<Entrenador, Integer> {
}
