package antonioloiacono.tesi.monolitica.service;

import antonioloiacono.tesi.monolitica.dto.VideogameCreateDto;
import antonioloiacono.tesi.monolitica.dto.VideogameDto;
import antonioloiacono.tesi.monolitica.dto.VideogameUpdateDto;
import java.util.Set;

public interface VideogameService {
    Set<VideogameDto> findAllVideogames();

    VideogameDto findVideogameById(Long id);

    VideogameDto createVideogame(VideogameCreateDto videogameCreateDto);

    VideogameDto updateVideogame(Long id, VideogameUpdateDto videogameUpdateDto);

    void deleteVideogame(Long id);

    VideogameDto addUserToVideogame(Long id, Long userId);

    VideogameDto removeUserToVideogame(Long id, Long userId);
}
