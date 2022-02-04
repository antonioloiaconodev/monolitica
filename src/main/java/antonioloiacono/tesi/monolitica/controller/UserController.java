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

    @GetMapping("/{username}")
    public ResponseEntity<UserDTO> findUserByUsername(@PathVariable("username") String username){
        UserDTO dto = userService.findUserByUsername(username);
        return new ResponseEntity<>(dto , HttpStatus.OK);
    }

    @PutMapping("/{username}")
    public ResponseEntity<Void> updateUser(@PathVariable("username") String username , @RequestBody UserDTO dto){
        UserDTO userDTO = userService.findUserByUsername(username);
        if(userDTO != null) {
            userService.updateUser(username, dto);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/{username}")
    public ResponseEntity<Void> deleteUserByUsername(@PathVariable("username") String username){
        UserDTO userDTO = userService.findUserByUsername(username);
        if(userDTO != null) {
            userService.deleteUser(username);
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
