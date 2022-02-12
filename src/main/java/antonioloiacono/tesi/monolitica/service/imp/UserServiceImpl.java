package antonioloiacono.tesi.monolitica.service.imp;

import antonioloiacono.tesi.monolitica.entity.User;
import antonioloiacono.tesi.monolitica.repository.UserRepository;
import antonioloiacono.tesi.monolitica.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> findAllUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    @Override
    public Optional<User> findUserById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public void deleteUser(Integer id) {
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
