package antonioloiacono.tesi.monolitica.service;

import antonioloiacono.tesi.monolitica.dto.UserDTO;
import java.util.List;

public interface UserService {

    void createUser(UserDTO userDTO);

    List<UserDTO> findAllUsers();

    UserDTO findUserById(Long id);

    void updateUser(Long id, UserDTO userDTO);

    void deleteUser(Long id);

    //List<UserDTO> findAuthorOlder55();
    //List<UserDTO> findAuthorWithMostCountOfBooks();
}
