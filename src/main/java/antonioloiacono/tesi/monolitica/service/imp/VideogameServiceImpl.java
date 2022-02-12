package antonioloiacono.tesi.monolitica.service.imp;

import antonioloiacono.tesi.monolitica.entity.Videogame;
import antonioloiacono.tesi.monolitica.repository.VideogameRepository;
import antonioloiacono.tesi.monolitica.service.VideogameService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VideogameServiceImpl implements VideogameService {

    private final VideogameRepository videogameRepository;

    public VideogameServiceImpl(VideogameRepository videogameRepository) {
        this.videogameRepository = videogameRepository;
    }

    @Override
    public Videogame saveVideogame(Videogame videogame) {
        return videogameRepository.save(videogame);
    }

    @Override
    public List<Videogame> findAllVideogames() {
        List<Videogame> videogames = new ArrayList<>();
        videogameRepository.findAll().forEach(videogames::add);
        return videogames;
    }

    @Override
    public Optional<Videogame> findVideogameById(int id) {
        return videogameRepository.findById(id);
    }

    @Override
    public void deleteVideogame(int id) {
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
