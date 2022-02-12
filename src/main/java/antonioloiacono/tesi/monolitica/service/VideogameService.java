package antonioloiacono.tesi.monolitica.service;

import antonioloiacono.tesi.monolitica.entity.Videogame;
import java.util.List;
import java.util.Optional;

public interface VideogameService {

    Videogame saveVideogame(Videogame videogame);

    List<Videogame> findAllVideogames();

    Optional<Videogame> findVideogameById(int id);

    void deleteVideogame(int id);
}
