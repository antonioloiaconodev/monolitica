package antonioloiacono.tesi.monolitica.service;

import antonioloiacono.tesi.monolitica.dto.VideogameDTO;

import java.util.List;

public interface VideogameService {

    void createVideogame(VideogameDTO videogameDTO);

    List<VideogameDTO> findAllVideogames();

    VideogameDTO findVideogameById(Long id);

    void updateVideogame(Long id, VideogameDTO videogameDTO);

    void deleteVideogame(Long id);

    //VideogameDTO findCountByGenre(String genre);
    //VideogameDTO findVideogame();
}
