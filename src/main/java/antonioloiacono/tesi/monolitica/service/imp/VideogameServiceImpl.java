package antonioloiacono.tesi.monolitica.service.imp;

import antonioloiacono.tesi.monolitica.dto.VideogameSaveDTO;
import antonioloiacono.tesi.monolitica.dto.VideogameUpdateDTO;
import antonioloiacono.tesi.monolitica.entity.User;
import antonioloiacono.tesi.monolitica.entity.Videogame;
import antonioloiacono.tesi.monolitica.exception.RecordAlreadyExistsException;
import antonioloiacono.tesi.monolitica.exception.RecordNotFoundException;
import antonioloiacono.tesi.monolitica.repository.UserRepository;
import antonioloiacono.tesi.monolitica.repository.VideogameRepository;
import antonioloiacono.tesi.monolitica.service.VideogameService;
import antonioloiacono.tesi.monolitica.util.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class VideogameServiceImpl implements VideogameService {
    private VideogameRepository videogameRepository;
    private UserRepository userRepository;
    private ModelMapper modelMapper;

    @Autowired
    public VideogameServiceImpl(VideogameRepository videogameRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.videogameRepository = videogameRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Videogame saveVideogame(VideogameSaveDTO dto) {
        String name = dto.getName();
        if (videogameRepository.existsByName(name)) {
            throw new RecordAlreadyExistsException("Videogame already exist with name: " + name);
        }
        Videogame videogame = modelMapper.map(dto, Videogame.class);
        if (dto.getUserId() != null){
            this.addVideogameUser(dto.getUserId(), videogame);
        }
        return videogameRepository.save(videogame);
    }

    @Override
    public Videogame updateVideogame(int id, VideogameUpdateDTO dto) {
        Optional<Videogame> optionalVideogame = videogameRepository.findById(id);
        if (optionalVideogame.isEmpty()) {
            throw new RecordNotFoundException("No videogame to update found with the id: " + id);
        }
        Videogame videogame = optionalVideogame.get();
        if (dto.getName() != null){
            videogame.setName(dto.getName());
        }
        if (dto.getPlatform() != null){
            videogame.setPlatform(dto.getPlatform());
        }
        if (dto.getGenre() != null){
            videogame.setGenre(dto.getGenre());
        }
        if (dto.getPublisher() != null){
            videogame.setPublisher(dto.getPublisher());
        }
        if (dto.getReleaseDate() != null){
            videogame.setReleaseDate(dto.getReleaseDate());
        }
        if (dto.getUserId() != null){
            this.addVideogameUser(dto.getUserId(), videogame);
        }
        return videogameRepository.save(videogame);
    }

    @Override
    public Set<Videogame> findAllVideogames() {
        Set<Videogame> videogames = new HashSet<>();
        videogameRepository.findAll().forEach(videogames::add);
        return videogames;
    }

    @Override
    public Videogame findVideogameById(int id) {
        Optional<Videogame> optionalVideogame = videogameRepository.findById(id);
        if (optionalVideogame.isEmpty()) {
            throw new RecordNotFoundException("No videogame found with the id: " + id);
        }
        return optionalVideogame.get();
    }

    @Override
    public void deleteVideogame(int id) {
        Optional<Videogame> optionalVideogame = videogameRepository.findById(id);
        if (optionalVideogame.isEmpty()) {
            throw new RecordNotFoundException("No videogame to delete found with the id: " + id);
        }
        videogameRepository.deleteById(id);
    }

    @Override
    public void addVideogameUser(int userId, Videogame videogame) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isEmpty()) {
            throw new RecordNotFoundException("No user found with the Id: " + userId);
        }
        videogame.addUser(optionalUser.get());
    }
}
