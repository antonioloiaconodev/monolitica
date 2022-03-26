package antonioloiacono.tesi.monolitica.service.imp;

import antonioloiacono.tesi.monolitica.dto.VideogameCreateDto;
import antonioloiacono.tesi.monolitica.dto.VideogameDto;
import antonioloiacono.tesi.monolitica.dto.VideogameUpdateDto;
import antonioloiacono.tesi.monolitica.entity.Videogame;
import antonioloiacono.tesi.monolitica.entity.Videogame;
import antonioloiacono.tesi.monolitica.exception.RecordAlreadyExistsException;
import antonioloiacono.tesi.monolitica.exception.RecordNotFoundException;
import antonioloiacono.tesi.monolitica.repository.VideogameRepository;
import antonioloiacono.tesi.monolitica.repository.VideogameRepository;
import antonioloiacono.tesi.monolitica.service.VideogameService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class VideogameServiceImpl implements VideogameService {

    private final VideogameRepository videogameRepository;
    private final ModelMapper modelMapper;

    public VideogameServiceImpl(
            VideogameRepository videogameRepository,
            ModelMapper modelMapper
    ) {
        super();
        this.videogameRepository = videogameRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Set<VideogameDto> findAllVideogames() {
        return videogameRepository.findAll().stream().map(videogame -> modelMapper.map(videogame, VideogameDto.class))
                .collect(Collectors.toSet());
    }

    @Override
    public VideogameDto findVideogameById(Long id) {
        Videogame videogame = videogameRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("No videogame found with the id: " + id));
        return modelMapper.map(videogame, VideogameDto.class);
    }

    @Override
    public VideogameDto createVideogame(VideogameCreateDto videogameCreateDto) {
        String name = videogameCreateDto.getName();
        Optional<Videogame> videogame = videogameRepository.findByName(name);
        if(videogame.isPresent()){
            throw new RecordAlreadyExistsException("Videogame already exist with email: " + name);
        }
        Videogame videogameCreate = videogameRepository.save(modelMapper.map(videogameCreateDto, Videogame.class));
        return modelMapper.map(videogameCreate, VideogameDto.class);
    }

    @Override
    public VideogameDto updateVideogame(Long id, VideogameUpdateDto videogameUpdateDto) {
        Videogame videogame = videogameRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("No videogame to update found with the id: " + id));
       //TODO USARE BEANUTILS.COPY E' LO STESSO?
        if (videogameUpdateDto.getName() != null){
            videogame.setName(videogameUpdateDto.getName());
        }
        if (videogameUpdateDto.getPlatform() != null){
            videogame.setPlatform(videogameUpdateDto.getPlatform());
        }
        if (videogameUpdateDto.getGenre() != null){
            videogame.setGenre(videogameUpdateDto.getGenre());
        }
        if (videogameUpdateDto.getPublisher() != null){
            videogame.setPublisher(videogameUpdateDto.getPublisher());
        }
        if (videogameUpdateDto.getReleaseDate() != null){
            videogame.setReleaseDate(videogameUpdateDto.getReleaseDate());
        }
        Videogame videogameUpdate = videogameRepository.save(videogame);
        return modelMapper.map(videogameUpdate, VideogameDto.class);
    }

    @Override
    public void deleteVideogame(Long id) {
        Videogame videogame = videogameRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("No videogame to delete found with the id: " + id));
        videogameRepository.delete(videogame);
    }
}