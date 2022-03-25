package antonioloiacono.tesi.monolitica.repository;

import antonioloiacono.tesi.monolitica.entity.Videogame;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VideogameRepository extends JpaRepository<Videogame, Long> {
    Optional<Videogame> findByName(String name);
}
