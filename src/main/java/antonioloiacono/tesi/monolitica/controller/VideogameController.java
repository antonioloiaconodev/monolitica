package antonioloiacono.tesi.monolitica.controller;

import antonioloiacono.tesi.monolitica.dto.VideogameDTO;
import antonioloiacono.tesi.monolitica.entity.User;
import antonioloiacono.tesi.monolitica.entity.Videogame;
import antonioloiacono.tesi.monolitica.exception.ResourceNotFoundException;
import antonioloiacono.tesi.monolitica.service.UserService;
import antonioloiacono.tesi.monolitica.service.VideogameService;
import antonioloiacono.tesi.monolitica.util.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/videogames")
public class VideogameController {

    private final VideogameService videogameService;
    private final UserService userService;
    private final ModelMapper modelMapper;

    public VideogameController(VideogameService videogameService, UserService userService, ModelMapper modelMapper) {
        this.videogameService = videogameService;
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public ResponseEntity<Videogame> createVideogame(@Valid @RequestBody VideogameDTO dto) throws ResourceNotFoundException {
        Long userId = dto.getUserId();
        Videogame videogame = modelMapper.map(dto, Videogame.class);
        /*if(userId != null) {
            if (userId.intValue() > 0) {
                Optional<User> optionalUser = userService.findUserById(userId);
                if (optionalUser.isEmpty()) {
                    throw new ResourceNotFoundException("No user found with the Id: " + userId);
                }
                videogame.addUser(optionalUser.get());
            } else {
                throw new ResourceNotFoundException("The user's Id must be greater than 0");
            }
        }*/
        Videogame createdVideogame = videogameService.saveVideogame(videogame);
        return new ResponseEntity<>(createdVideogame, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Videogame>> findAllVideogames(){
        return new ResponseEntity<>(videogameService.findAllVideogames(), HttpStatus.OK);
    }

    @GetMapping("/{videogameId}")
    public ResponseEntity<Videogame> findVideogameById(@PathVariable("videogameId") int id) throws ResourceNotFoundException {
        Optional<Videogame> optionalVideogame = videogameService.findVideogameById(id);
        if (optionalVideogame.isEmpty()) {
            throw new ResourceNotFoundException("No videogame found with the id: " + id);
        }
        return new ResponseEntity<>(optionalVideogame.get() , HttpStatus.OK);
    }

    /*@PutMapping("/{videogameId}")
    public ResponseEntity<Void> updateVideogame(@PathVariable("videogameId") Long id, @RequestBody VideogameDTO dto){
        VideogameDTO videogameDTO = videogameService.findVideogameById(id);
        if(videogameDTO != null) {
            dto.setId(id);
            videogameService.saveVideogame(dto);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{videogameId}")
    public ResponseEntity<Void> deleteVideogameById(@PathVariable("videogameId") Long id){
        VideogameDTO videogameDTO = videogameService.findVideogameById(id);
        if(videogameDTO != null) {
            videogameService.deleteVideogame(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }*/
    
}
