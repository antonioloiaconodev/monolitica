package antonioloiacono.tesi.monolitica.service;

import antonioloiacono.tesi.monolitica.entity.User;
import java.util.List;
import java.util.Optional;

public interface UserService {

    User saveUser(User user);

    List<User> findAllUsers();

    Optional<User> findUserById(Integer id);

    void deleteUser(Integer id);
}
