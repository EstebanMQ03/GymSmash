package GymSmash.Repository;

import GymSmash.Model.Agendar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendarRepository extends JpaRepository<Agendar, Long> {
}
