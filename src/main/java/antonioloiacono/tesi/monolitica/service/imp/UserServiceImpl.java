package antonioloiacono.tesi.monolitica.service.imp;

import antonioloiacono.tesi.monolitica.dto.UserDTO;
import antonioloiacono.tesi.monolitica.model.User;
import antonioloiacono.tesi.monolitica.repository.UserRepository;
import antonioloiacono.tesi.monolitica.service.UserService;
import antonioloiacono.tesi.monolitica.util.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ObjectMapperUtils modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ObjectMapperUtils modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void createUser(UserDTO userDTO) {
        userRepository.save(modelMapper.map(userDTO, User.class));
    }

    @Override
    public List<UserDTO> findAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserDTO> userDTOS = modelMapper.mapAll(users, UserDTO.class);
        return userDTOS;
    }

    @Override
    public UserDTO findUserById(Long id) {
        User user = userRepository.findById(id).get();
        UserDTO userDTO = modelMapper.map(user, UserDTO.class);
        return userDTO;
    }

    @Override
    public void updateUser(Long id, UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        user.setId(id);
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    /*@Override
    public List<AuthorDTO> findAuthorOlder55() {
        List<AuthorEntity> authorEntities = authorRepository.findAuthorOlder55();
        List<AuthorDTO> dtos = modelMapper.mapAll(authorEntities , AuthorDTO.class);
        return dtos;
    }

    @Override
    public List<AuthorDTO> findAuthorWithMostCountOfBooks() {
        List<AuthorEntity> authorEntities = authorRepository.findAuthorWithMostCountOfBooks();
        List<AuthorDTO> dto = modelMapper.mapAll(authorEntities , AuthorDTO.class);
        return dto;
    }*/
}
