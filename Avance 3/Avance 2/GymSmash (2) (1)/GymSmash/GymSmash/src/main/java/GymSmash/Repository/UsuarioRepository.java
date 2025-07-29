package GymSmash.Repository;


import GymSmash.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Usuario findByUsernameAndPassword(String username, String password);
}