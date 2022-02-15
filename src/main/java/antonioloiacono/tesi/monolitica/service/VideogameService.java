package antonioloiacono.tesi.monolitica.service;

import antonioloiacono.tesi.monolitica.dto.VideogameSaveDTO;
import antonioloiacono.tesi.monolitica.dto.VideogameUpdateDTO;
import antonioloiacono.tesi.monolitica.entity.Videogame;
import antonioloiacono.tesi.monolitica.exception.ResourceAlreadyExistsException;
import antonioloiacono.tesi.monolitica.exception.ResourceNotFoundException;
import java.util.Set;

public interface VideogameService {
    Videogame saveVideogame(VideogameSaveDTO dto) throws ResourceAlreadyExistsException;

    Videogame updateVideogame(int id, VideogameUpdateDTO dto) throws ResourceNotFoundException;

    Set<Videogame> findAllVideogames() throws ResourceNotFoundException;

    Videogame findVideogameById(int id) throws ResourceNotFoundException;

    void deleteVideogame(int id) throws ResourceNotFoundException;

    void addVideogameUser(int userId, Videogame videogame) throws ResourceNotFoundException;
}
