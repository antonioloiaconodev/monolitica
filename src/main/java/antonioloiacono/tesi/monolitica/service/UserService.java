package antonioloiacono.tesi.monolitica.service;

import antonioloiacono.tesi.monolitica.dto.UserSaveDTO;
import antonioloiacono.tesi.monolitica.dto.UserUpdateDTO;
import antonioloiacono.tesi.monolitica.entity.User;
import antonioloiacono.tesi.monolitica.exception.ResourceAlreadyExistsException;
import antonioloiacono.tesi.monolitica.exception.ResourceNotFoundException;
import java.util.List;
import java.util.Set;

public interface UserService {
    User saveUser(UserSaveDTO dto) throws ResourceAlreadyExistsException;

    User updateUser(int id, UserUpdateDTO dto) throws ResourceNotFoundException;

    Set<User> findAllUsers() throws ResourceNotFoundException;

    User findUserById(int id) throws ResourceNotFoundException;

    void deleteUser(int id) throws ResourceNotFoundException;
}
