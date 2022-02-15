package antonioloiacono.tesi.monolitica.repository;

import antonioloiacono.tesi.monolitica.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsByEmail(String email);
}
