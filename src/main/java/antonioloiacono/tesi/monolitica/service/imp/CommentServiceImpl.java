package antonioloiacono.tesi.monolitica.service.imp;

import antonioloiacono.tesi.monolitica.dto.CommentDto;
import antonioloiacono.tesi.monolitica.dto.CommentCreateDto;
import antonioloiacono.tesi.monolitica.dto.CommentUpdateDto;
import antonioloiacono.tesi.monolitica.entity.Comment;
import antonioloiacono.tesi.monolitica.entity.User;
import antonioloiacono.tesi.monolitica.entity.Videogame;
import antonioloiacono.tesi.monolitica.exception.RecordNotFoundException;
import antonioloiacono.tesi.monolitica.repository.CommentRepository;
import antonioloiacono.tesi.monolitica.repository.UserRepository;
import antonioloiacono.tesi.monolitica.repository.VideogameRepository;
import antonioloiacono.tesi.monolitica.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final VideogameRepository videogameRepository;
    private final ModelMapper modelMapper;

    public CommentServiceImpl(
            CommentRepository commentRepository,
            UserRepository userRepository,
            VideogameRepository videogameRepository,
            ModelMapper modelMapper
    ) {
        super();
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
        this.videogameRepository = videogameRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Set<CommentDto> findAllComments() {
        return commentRepository.findAll().stream().map(comment -> modelMapper.map(comment, CommentDto.class))
                .collect(Collectors.toSet());
    }

    @Override
    public CommentDto findCommentById(Long id) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("No comment found with the id: " + id));
        return modelMapper.map(comment, CommentDto.class);
    }

    @Override
    public CommentDto createComment(CommentCreateDto commentCreateDto) {
        Long userId = commentCreateDto.getUserId();
        Long videogameId = commentCreateDto.getVideogameId();
        String comment = commentCreateDto.getComment();
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RecordNotFoundException("No user found with the id: " + userId));
        Videogame videogame = videogameRepository.findById(videogameId)
                .orElseThrow(() -> new RecordNotFoundException("No videogame found with the id: " + videogameId));
        Comment commentCreate = new Comment();
        commentCreate.setUser(user);
        commentCreate.setVideogame(videogame);
        commentCreate.setComment(comment);
        return modelMapper.map(commentRepository.save(commentCreate), CommentDto.class);
    }

    @Override
    public CommentDto updateComment(Long id, CommentUpdateDto commentUpdateDto) {
        Long userId = commentUpdateDto.getUserId();
        Long videogameId = commentUpdateDto.getVideogameId();
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("No comment found with the id: " + id));
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RecordNotFoundException("No user found with the id: " + userId));
        Videogame videogame = videogameRepository.findById(videogameId)
                .orElseThrow(() -> new RecordNotFoundException("No videogame found with the id: " + videogameId));
        comment.setUser(user);
        comment.setVideogame(videogame);
        if (commentUpdateDto.getComment() != null){
            comment.setComment(commentUpdateDto.getComment());
        }
        return modelMapper.map(commentRepository.save(comment), CommentDto.class);
    }

    @Override
    public void deleteComment(Long id) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("No comment to delete found with the id: " + id));
        commentRepository.delete(comment);
    }
}
