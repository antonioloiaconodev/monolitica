package antonioloiacono.tesi.monolitica.repository;

import antonioloiacono.tesi.monolitica.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
