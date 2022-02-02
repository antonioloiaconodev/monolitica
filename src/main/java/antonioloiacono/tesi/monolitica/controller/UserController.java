package antonioloiacono.tesi.monolitica.controller;


import antonioloiacono.tesi.monolitica.dto.UserDTO;
import antonioloiacono.tesi.monolitica.model.User;
import antonioloiacono.tesi.monolitica.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody UserDTO dto){
        userService.createUser(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAllUsers(){
        List<UserDTO> dtos = userService.findAllUsers();
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping("/id/{userId}")
    public ResponseEntity<UserDTO> findUserById(@PathVariable("userId") Long id){
        UserDTO dto = userService.findUserById(id);
        return new ResponseEntity<>(dto , HttpStatus.OK);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<Void> updateUser(@PathVariable("userId") Long id , @RequestBody UserDTO dto){
        UserDTO userDTO = userService.findUserById(id);
        if(userDTO != null) {
            userService.updateUser(id, dto);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUserById(@PathVariable("userId") Long id){
        UserDTO userDTO = userService.findUserById(id);
        if(userDTO != null) {
            userService.deleteUser(id);
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
