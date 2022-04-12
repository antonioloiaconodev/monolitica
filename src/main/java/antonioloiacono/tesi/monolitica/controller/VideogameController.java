package antonioloiacono.tesi.monolitica.controller;

import antonioloiacono.tesi.monolitica.dto.*;
import antonioloiacono.tesi.monolitica.service.VideogameService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("/api/videogames")
public class VideogameController {

    private final VideogameService videogameService;

    public VideogameController(VideogameService videogameService) {
        super();
        this.videogameService = videogameService;
    }

    @GetMapping
    public ResponseEntity<Set<VideogameDto>> findAllVideogames() {
        return new ResponseEntity<>(videogameService.findAllVideogames(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VideogameDto> findVideogameById(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(videogameService.findVideogameById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<VideogameDto> createVideogame(@Valid @RequestBody VideogameCreateDto videogameCreateDto) {
        return new ResponseEntity<>(videogameService.createVideogame(videogameCreateDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VideogameDto> updateVideogame(@PathVariable Long id, @Valid @RequestBody VideogameUpdateDto videogameUpdateDto) {
        return new ResponseEntity<>(videogameService.updateVideogame(id, videogameUpdateDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteVideogame(@PathVariable(name = "id") Long id) {
        videogameService.deleteVideogame(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}/users/{userId}")
    public ResponseEntity<VideogameDto> addUserToVideogame(@PathVariable(name = "id") Long id, @PathVariable(name = "userId") Long userId) {
        return new ResponseEntity<>(videogameService.addUserToVideogame(id, userId), HttpStatus.OK);
    }

    @DeleteMapping("/{id}/users/{userId}")
    public ResponseEntity<VideogameDto> removeUserToVideogame(@PathVariable(name = "id") Long id, @PathVariable(name = "userId") Long userId) {
        return new ResponseEntity<>(videogameService.removeUserToVideogame(id, userId), HttpStatus.OK);
    }
}
