package antonioloiacono.tesi.monolitica.service;

import antonioloiacono.tesi.monolitica.dto.UserDTO;
import java.util.List;

public interface UserService {

    void createUser(UserDTO userDTO);

    List<UserDTO> findAllUsers();

    UserDTO findUserByUsername(String username);

    void updateUser(String username, UserDTO userDTO);

    void deleteUser(String username);

    //List<UserDTO> findAuthorWithMostCountOfBooks();
}
