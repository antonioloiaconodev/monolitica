package antonioloiacono.tesi.monolitica.service;

import antonioloiacono.tesi.monolitica.dto.VideogameSaveDTO;
import antonioloiacono.tesi.monolitica.dto.VideogameUpdateDTO;
import antonioloiacono.tesi.monolitica.entity.Videogame;
import antonioloiacono.tesi.monolitica.exception.RecordAlreadyExistsException;
import antonioloiacono.tesi.monolitica.exception.RecordNotFoundException;
import java.util.Set;

public interface VideogameService {
    Videogame saveVideogame(VideogameSaveDTO dto) throws RecordAlreadyExistsException;

    Videogame updateVideogame(int id, VideogameUpdateDTO dto) throws RecordNotFoundException;

    Set<Videogame> findAllVideogames() throws RecordNotFoundException;

    Videogame findVideogameById(int id) throws RecordNotFoundException;

    void deleteVideogame(int id) throws RecordNotFoundException;

    void addVideogameUser(int userId, Videogame videogame) throws RecordNotFoundException;
}
