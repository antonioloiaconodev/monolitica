package antonioloiacono.tesi.monolitica.service;

import antonioloiacono.tesi.monolitica.dto.VideogameCreateDto;
import antonioloiacono.tesi.monolitica.dto.VideogameDto;
import antonioloiacono.tesi.monolitica.dto.VideogameUpdateDto;
import java.util.List;

public interface VideogameService {
    List<VideogameDto> findAllVideogames();

    VideogameDto findVideogameById(Long id);

    VideogameDto createVideogame(VideogameCreateDto videogameCreateDto);

    VideogameDto updateVideogame(Long id, VideogameUpdateDto videogameUpdateDto);

    void deleteVideogame(Long id);
}
