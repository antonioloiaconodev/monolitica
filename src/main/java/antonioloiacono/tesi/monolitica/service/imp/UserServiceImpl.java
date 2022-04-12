package antonioloiacono.tesi.monolitica.service.imp;

import antonioloiacono.tesi.monolitica.dto.UserCreateDto;
import antonioloiacono.tesi.monolitica.dto.UserDto;
import antonioloiacono.tesi.monolitica.dto.UserUpdateDto;
import antonioloiacono.tesi.monolitica.entity.User;
import antonioloiacono.tesi.monolitica.exception.RecordAlreadyExistsException;
import antonioloiacono.tesi.monolitica.exception.RecordNotFoundException;
import antonioloiacono.tesi.monolitica.repository.UserRepository;
import antonioloiacono.tesi.monolitica.repository.VideogameRepository;
import antonioloiacono.tesi.monolitica.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(
            UserRepository userRepository,
            ModelMapper modelMapper
    ) {
        super();
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Set<UserDto> findAllUsers() {
        return userRepository.findAll().stream().map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toSet());
    }

    @Override
    public UserDto findUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("No user found with the id: " + id));
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public UserDto createUser(UserCreateDto userCreateDto) {
        String email = userCreateDto.getEmail();
        Optional<User> user = userRepository.findByEmail(email);
        if(user.isPresent()){
            throw new RecordAlreadyExistsException("User already exist with email: " + email);
        }
        User userCreate = userRepository.save(modelMapper.map(userCreateDto, User.class));
        return modelMapper.map(userCreate, UserDto.class);
    }

    @Override
    public UserDto updateUser(Long id, UserUpdateDto userUpdateDto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("No user found with the id: " + id));
        if (userUpdateDto.getEmail() != null){
            user.setEmail(userUpdateDto.getEmail());
        }
        if (userUpdateDto.getFirstName() != null){
            user.setFirstName(userUpdateDto.getFirstName());
        }
        if (userUpdateDto.getLastName() != null){
            user.setLastName(userUpdateDto.getLastName());
        }
        User userUpdate = userRepository.save(user);
        return modelMapper.map(userUpdate, UserDto.class);
    }
}
