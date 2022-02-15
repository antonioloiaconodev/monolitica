package antonioloiacono.tesi.monolitica.controller;

import antonioloiacono.tesi.monolitica.dto.VideogameSaveDTO;
import antonioloiacono.tesi.monolitica.dto.VideogameUpdateDTO;
import antonioloiacono.tesi.monolitica.entity.Videogame;
import antonioloiacono.tesi.monolitica.service.UserService;
import antonioloiacono.tesi.monolitica.service.VideogameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("/videogames")
public class VideogameController {
    private final VideogameService videogameService;
    private final UserService userService;

    @Autowired
    public VideogameController(VideogameService videogameService, UserService userService) {
        this.videogameService = videogameService;
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Videogame> createVideogame(@Valid @RequestBody VideogameSaveDTO req) {
        return new ResponseEntity<>(videogameService.saveVideogame(req), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Set<Videogame>> findAllVideogames() {
        return new ResponseEntity<>(videogameService.findAllVideogames(), HttpStatus.OK);
    }

    @GetMapping("/{videogameId}")
    public ResponseEntity<Videogame> findVideogameById(@PathVariable("videogameId") int id) {
        return new ResponseEntity<>(videogameService.findVideogameById(id) , HttpStatus.OK);
    }

    @PutMapping("/{videogameId}")
    public ResponseEntity<Videogame> updateUser(@PathVariable("videogameId") int id, @Valid @RequestBody VideogameUpdateDTO req) {
        return new ResponseEntity<>(videogameService.updateVideogame(id, req), HttpStatus.OK);
    }

    @DeleteMapping("/{videogameId}")
    public ResponseEntity<Void> deleteVideogameById(@PathVariable("videogameId") int id) {
        videogameService.deleteVideogame(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
