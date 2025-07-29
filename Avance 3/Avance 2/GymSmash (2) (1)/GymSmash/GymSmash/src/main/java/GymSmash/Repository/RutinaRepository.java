package GymSmash.Repository;

import GymSmash.Model.Rutina;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RutinaRepository extends JpaRepository<Rutina, Integer> {
}
