package antonioloiacono.tesi.monolitica.service.imp;

import antonioloiacono.tesi.monolitica.dto.CommentDTO;
import antonioloiacono.tesi.monolitica.entity.Comment;
import antonioloiacono.tesi.monolitica.entity.User;
import antonioloiacono.tesi.monolitica.entity.Videogame;
import antonioloiacono.tesi.monolitica.exception.RecordNotFoundException;
import antonioloiacono.tesi.monolitica.repository.CommentRepository;
import antonioloiacono.tesi.monolitica.repository.UserRepository;
import antonioloiacono.tesi.monolitica.repository.VideogameRepository;
import antonioloiacono.tesi.monolitica.service.CommentService;
import antonioloiacono.tesi.monolitica.util.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class CommentServiceImpl implements CommentService {
    private CommentRepository commentRepository;
    private UserRepository userRepository;
    private VideogameRepository videogameRepository;
    private ModelMapper modelMapper;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository, UserRepository userRepository, VideogameRepository videogameRepository, ModelMapper modelMapper) {
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
        this.videogameRepository = videogameRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Comment saveComment(CommentDTO dto) {
        int userId = dto.getUserId();
        int videogameId = dto.getVideogameId();
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isEmpty()) {
            throw new RecordNotFoundException("No user found with the id: " + userId);
        }
        Optional<Videogame> optionalVideogame = videogameRepository.findById(videogameId);
        if (optionalVideogame.isEmpty()) {
            throw new RecordNotFoundException("No videogame found with the id: " + videogameId);
        }
        Comment comment = modelMapper.map(dto, Comment.class);
        comment.setUser(optionalUser.get());
        comment.setVideogame(optionalVideogame.get());
        return commentRepository.save(comment);
    }

    @Override
    public Comment updateComment(int id, CommentDTO dto) {
        int userId = dto.getUserId();
        int videogameId = dto.getVideogameId();
        Optional<Comment> optionalComment = commentRepository.findById(id);
        if (optionalComment.isEmpty()) {
            throw new RecordNotFoundException("No comment to update found with the id: " + id);
        }
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isEmpty()) {
            throw new RecordNotFoundException("No user found with the id: " + userId);
        }
        Optional<Videogame> optionalVideogame = videogameRepository.findById(videogameId);
        if (optionalVideogame.isEmpty()) {
            throw new RecordNotFoundException("No videogame found with the id: " + videogameId);
        }
        Comment comment = optionalComment.get();
        comment.setUser(optionalUser.get());
        comment.setVideogame(optionalVideogame.get());
        comment.setComment(dto.getComment());
        return commentRepository.save(comment);
    }

    @Override
    public Set<Comment> findAllComments() {
        Set<Comment> comments = new HashSet<>();
        commentRepository.findAll().forEach(comments::add);
        return comments;
    }

    @Override
    public Comment findCommentById(int id) {
        Optional<Comment> optionalComment = commentRepository.findById(id);
        if (optionalComment.isEmpty()) {
            throw new RecordNotFoundException("No comment found with the id: " + id);
        }
        return optionalComment.get();
    }

    @Override
    public void deleteComment(int id) {
        Optional<Comment> optionalComment = commentRepository.findById(id);
        if (optionalComment.isEmpty()) {
            throw new RecordNotFoundException("No comment to delete found with the id: " + id);
        }
        commentRepository.deleteById(id);
    }
}
