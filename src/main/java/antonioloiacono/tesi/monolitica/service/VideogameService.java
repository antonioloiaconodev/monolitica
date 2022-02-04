package antonioloiacono.tesi.monolitica.service;

import antonioloiacono.tesi.monolitica.dto.VideogameDTO;

import java.util.List;

public interface VideogameService {

    void createVideogame(VideogameDTO videogameDTO);

    List<VideogameDTO> findAllVideogames();

    VideogameDTO findVideogameByName(String name);

    void updateVideogame(String name, VideogameDTO videogameDTO);

    void deleteVideogame(String name);

    //VideogameDTO findCountByGenre(String genre);
    //VideogameDTO findVideogame();
}
