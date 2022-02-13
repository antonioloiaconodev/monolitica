package antonioloiacono.tesi.monolitica.service;

import antonioloiacono.tesi.monolitica.dto.UserSaveDTO;
import antonioloiacono.tesi.monolitica.dto.UserUpdateDTO;
import antonioloiacono.tesi.monolitica.entity.User;
import antonioloiacono.tesi.monolitica.exception.ResourceAlreadyExistsException;
import antonioloiacono.tesi.monolitica.exception.ResourceNotFoundException;
import java.util.List;

public interface UserService {
    User saveUser(UserSaveDTO dto) throws ResourceAlreadyExistsException;

    User updateUser(Long id, UserUpdateDTO dto) throws ResourceNotFoundException;

    List<User> findAllUsers() throws ResourceNotFoundException;

    User findUserById(Long id) throws ResourceNotFoundException;

    void deleteUser(Long id) throws ResourceNotFoundException;
}
