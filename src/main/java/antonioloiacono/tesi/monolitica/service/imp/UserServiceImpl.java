package antonioloiacono.tesi.monolitica.service.imp;

import antonioloiacono.tesi.monolitica.dto.UserSaveDTO;
import antonioloiacono.tesi.monolitica.dto.UserUpdateDTO;
import antonioloiacono.tesi.monolitica.entity.User;
import antonioloiacono.tesi.monolitica.exception.ResourceAlreadyExistsException;
import antonioloiacono.tesi.monolitica.exception.ResourceNotFoundException;
import antonioloiacono.tesi.monolitica.repository.UserRepository;
import antonioloiacono.tesi.monolitica.service.UserService;
import antonioloiacono.tesi.monolitica.util.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public User saveUser(UserSaveDTO dto) {
        String email = dto.getEmail();
        if (userRepository.existsByEmail(email)) {
            throw new ResourceAlreadyExistsException("User already exist with email: " + email);
        }
        return userRepository.save(modelMapper.map(dto, User.class));
    }

    @Override
    public User updateUser(int id, UserUpdateDTO dto) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            throw new ResourceNotFoundException("No user to update found with the id: " + id);
        }
        User user = optionalUser.get();
        if (dto.getEmail() != null){
            user.setEmail(dto.getEmail());
        }
        if (dto.getFirstName() != null){
            user.setFirstName(dto.getFirstName());
        }
        if (dto.getLastName() != null){
            user.setLastName(dto.getLastName());
        }
        return userRepository.save(user);
    }

    @Override
    public Set<User> findAllUsers() {
        Set<User> users = new HashSet<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    @Override
    public User findUserById(int id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            throw new ResourceNotFoundException("No user found with the id: " + id);
        }
        return optionalUser.get();
    }

    @Override
    public void deleteUser(int id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            throw new ResourceNotFoundException("No user to delete found with the id: " + id);
        }
        userRepository.deleteById(id);
    }
}
