package antonioloiacono.tesi.monolitica.repository;

import antonioloiacono.tesi.monolitica.entity.Videogame;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideogameRepository extends JpaRepository<Videogame, Integer> {}
