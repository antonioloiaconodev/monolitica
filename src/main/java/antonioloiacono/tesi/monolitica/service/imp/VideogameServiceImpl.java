package antonioloiacono.tesi.monolitica.service.imp;

import antonioloiacono.tesi.monolitica.dto.VideogameDTO;
import antonioloiacono.tesi.monolitica.model.Videogame;
import antonioloiacono.tesi.monolitica.repository.VideogameRepository;
import antonioloiacono.tesi.monolitica.service.VideogameService;
import antonioloiacono.tesi.monolitica.util.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VideogameServiceImpl implements VideogameService {

    private final VideogameRepository videogameRepository;
    private final ObjectMapperUtils modelMapper;

    @Autowired
    public VideogameServiceImpl(VideogameRepository videogameRepository, ObjectMapperUtils modelMapper) {
        this.videogameRepository = videogameRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void createVideogame(VideogameDTO videogameDTO) {
        videogameRepository.save(modelMapper.map(videogameDTO, Videogame.class));
    }

    @Override
    public List<VideogameDTO> findAllVideogames() {
        List<Videogame> videogame = videogameRepository.findAll();
        List<VideogameDTO> videogameDTOS =  modelMapper.mapAll(videogame, VideogameDTO.class);
        return videogameDTOS;
    }

    @Override
    public VideogameDTO findVideogameByName(String name) {
        Videogame videogame = videogameRepository.findByName(name);
        VideogameDTO videogameDTO = modelMapper.map(videogame, VideogameDTO.class);
        return videogameDTO;
    }

    @Override
    public void updateVideogame(String name, VideogameDTO videogameDTO) {
        Long id = videogameRepository.findByName(name).getId();
        Videogame videogame = modelMapper.map(videogameDTO, Videogame.class);
        videogame.setId(id);
        videogameRepository.save(videogame);
    }

    @Override
    public void deleteVideogame(String name) {
        Long id = videogameRepository.findByName(name).getId();
        videogameRepository.deleteById(id);
    }

    /*@Override
    public BookDTO findCountByGenre(String genre) {
        BookEntity bookEntitie = bookRepository.findCountByGenre(genre);
        BookDTO dto = modelMapper.map(bookEntitie , BookDTO.class);
        return dto;
    }

    @Override
    public BookDTO findBook() {
        BookEntity bookEntity = bookRepository.findBook();
        BookDTO dto = modelMapper.map(bookEntity , BookDTO.class);
        return dto;
    }*/
}
