package antonioloiacono.tesi.monolitica.controller;


import antonioloiacono.tesi.monolitica.dto.VideogameDTO;
import antonioloiacono.tesi.monolitica.service.VideogameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/videogames")
public class VideogameController {

    private final VideogameService videogameService;

    @Autowired
    public VideogameController(VideogameService videogameService) {
        this.videogameService = videogameService;
    }

    @PostMapping
    public ResponseEntity<Void> createVideogame(@RequestBody VideogameDTO dto){
        videogameService.createVideogame(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<VideogameDTO>> findAllVideogames(){
        List<VideogameDTO> dtos = videogameService.findAllVideogames();
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<VideogameDTO> findVideogameByName(@PathVariable("name") String name){
        VideogameDTO dto = videogameService.findVideogameByName(name);
        return new ResponseEntity<>(dto , HttpStatus.OK);
    }

    @PutMapping("/{name}")
    public ResponseEntity<Void> updateVideogame(@PathVariable("name") String name , @RequestBody VideogameDTO dto){
        VideogameDTO videogameDTO = videogameService.findVideogameByName(name);
        if(videogameDTO != null) {
            videogameService.updateVideogame(name, dto);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/{name}")
    public ResponseEntity<Void> deleteVideogameByName(@PathVariable("name") String name){
        VideogameDTO videogameDTO = videogameService.findVideogameByName(name);
        if(videogameDTO != null) {
            videogameService.deleteVideogame(name);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /*
    //SELECT *  , count(ab.author_id) FROM author_book ab join author a on ab.book_id = a.id;
    @GetMapping("/findOlder55")
    public ResponseEntity<List<AuthorDTO>> findOlder55(){
        List<AuthorDTO> authordto = authorService.findAuthorOlder55();
        return new ResponseEntity<>(authordto, HttpStatus.OK);

    }
    @GetMapping("/findAuthor")
    public ResponseEntity<List<AuthorDTO>> findAuthorWithMostBooks(){
        List<AuthorDTO> dto = authorService.findAuthorWithMostCountOfBooks();
        return new ResponseEntity<>(dto , HttpStatus.OK);
    }
     */
}
