package antonioloiacono.tesi.monolitica.service;

import antonioloiacono.tesi.monolitica.dto.UserSaveDTO;
import antonioloiacono.tesi.monolitica.dto.UserUpdateDTO;
import antonioloiacono.tesi.monolitica.entity.User;
import antonioloiacono.tesi.monolitica.exception.RecordAlreadyExistsException;
import antonioloiacono.tesi.monolitica.exception.RecordNotFoundException;

import java.util.Set;

public interface UserService {
    User saveUser(UserSaveDTO dto) throws RecordAlreadyExistsException;

    User updateUser(int id, UserUpdateDTO dto) throws RecordNotFoundException;

    Set<User> findAllUsers() throws RecordNotFoundException;

    User findUserById(int id) throws RecordNotFoundException;

    void deleteUser(int id) throws RecordNotFoundException;
}
