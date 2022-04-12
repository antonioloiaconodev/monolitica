package antonioloiacono.tesi.monolitica.service;

import antonioloiacono.tesi.monolitica.dto.UserCreateDto;
import antonioloiacono.tesi.monolitica.dto.UserDto;
import antonioloiacono.tesi.monolitica.dto.UserUpdateDto;
import java.util.Set;

public interface UserService {
    Set<UserDto> findAllUsers();

    UserDto findUserById(Long id);

    UserDto createUser(UserCreateDto userCreateDto);

    UserDto updateUser(Long id, UserUpdateDto userUpdateDto);
}
