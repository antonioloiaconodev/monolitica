package antonioloiacono.tesi.monolitica.repository;

import antonioloiacono.tesi.monolitica.model.User;
import antonioloiacono.tesi.monolitica.model.Videogame;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideogameRepository extends JpaRepository<Videogame, Long> {

    Videogame findByName(String name);
}
