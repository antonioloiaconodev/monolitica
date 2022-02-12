package antonioloiacono.tesi.monolitica.controller;

import antonioloiacono.tesi.monolitica.dto.UserCreateDTO;
import antonioloiacono.tesi.monolitica.dto.UserUpdateDTO;
import antonioloiacono.tesi.monolitica.entity.User;
import antonioloiacono.tesi.monolitica.entity.Videogame;
import antonioloiacono.tesi.monolitica.exception.ResourceNotFoundException;
import antonioloiacono.tesi.monolitica.service.UserService;
import antonioloiacono.tesi.monolitica.util.ObjectMapperUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import java.io.DataInput;
import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final ObjectMapperUtils modelMapper;

    public UserController(UserService userService, ObjectMapperUtils modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public ResponseEntity<?> createUser(@Valid @RequestBody UserCreateDTO req) throws DataIntegrityViolationException {
        try{
            User createdUser = userService.saveUser(modelMapper.map(req, User.class));
            return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
        }catch (Exception ex){
            throw new DataIntegrityViolationException("User already exist with email: " + req.getEmail());
        }
    }

    @GetMapping
    public ResponseEntity<List<User>> findAllUsers(){
        return new ResponseEntity<>(userService.findAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> findUserById(@PathVariable("userId") Integer id) throws ResourceNotFoundException {
        Optional<User> optionalUser = userService.findUserById(id);
        if (optionalUser.isEmpty()) {
            throw new ResourceNotFoundException("No user found with the id: " + id);
        }
        return new ResponseEntity<>(optionalUser.get() , HttpStatus.OK);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable("userId") Integer id, @Valid @RequestBody UserUpdateDTO req) throws ResourceNotFoundException {
        Optional<User> optionalUser = userService.findUserById(id);
        if (optionalUser.isEmpty()) {
            throw new ResourceNotFoundException("No user found with the id: " + id);
        }
        User user = optionalUser.get();
        if (req.getEmail() != null){
            user.setEmail(req.getEmail());
        }
        if (req.getPassword() != null){
            user.setPassword(req.getPassword());
        }
        if (req.getFirstName() != null){
            user.setFirstName(req.getFirstName());
        }
        if (req.getLastName() != null){
            user.setLastName(req.getLastName());
        }
        User updatedUser = userService.saveUser(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUserById(@PathVariable("userId") Integer id) throws ResourceNotFoundException {
        Optional<User> optionalUser = userService.findUserById(id);
        if (optionalUser.isEmpty()) {
            throw new ResourceNotFoundException("No user found with the id: " + id);
        }
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
