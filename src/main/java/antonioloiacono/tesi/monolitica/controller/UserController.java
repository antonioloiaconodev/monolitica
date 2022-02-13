package antonioloiacono.tesi.monolitica.controller;

import antonioloiacono.tesi.monolitica.dto.UserSaveDTO;
import antonioloiacono.tesi.monolitica.dto.UserUpdateDTO;
import antonioloiacono.tesi.monolitica.entity.User;
import antonioloiacono.tesi.monolitica.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody UserSaveDTO req) {
        return new ResponseEntity<>(userService.saveUser(req), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<User>> findAllUsers() {
        return new ResponseEntity<>(userService.findAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> findUserById(@PathVariable("userId") Long id) {
        return new ResponseEntity<>(userService.findUserById(id) , HttpStatus.OK);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable("userId") Long id, @Valid @RequestBody UserUpdateDTO req) {
        return new ResponseEntity<>(userService.updateUser(id, req), HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUserById(@PathVariable("userId") Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
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
