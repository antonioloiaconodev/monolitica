package antonioloiacono.tesi.monolitica.service.imp;

import antonioloiacono.tesi.monolitica.dto.CommentDTO;
import antonioloiacono.tesi.monolitica.entity.Comment;
import antonioloiacono.tesi.monolitica.exception.ResourceNotFoundException;
import antonioloiacono.tesi.monolitica.repository.CommentRepository;
import antonioloiacono.tesi.monolitica.service.CommentService;
import antonioloiacono.tesi.monolitica.util.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository, ModelMapper modelMapper) {
        this.commentRepository = commentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Comment saveComment(CommentDTO dto) {
        return commentRepository.save(modelMapper.map(dto, Comment.class));
    }

    @Override
    public Comment updateComment(int id, CommentDTO dto) {
        Optional<Comment> optionalComment = commentRepository.findById(id);
        if (optionalComment.isEmpty()) {
            throw new ResourceNotFoundException("No comment to update found with the id: " + id);
        }
        Comment comment = optionalComment.get();
        //comment.setEmail(dto.getEmail());
        //comment.setFirstName(dto.getFirstName());
        //comment.setLastName(dto.getLastName());
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
            throw new ResourceNotFoundException("No comment found with the id: " + id);
        }
        return optionalComment.get();
    }

    @Override
    public void deleteComment(int id) {
        Optional<Comment> optionalComment = commentRepository.findById(id);
        if (optionalComment.isEmpty()) {
            throw new ResourceNotFoundException("No comment to delete found with the id: " + id);
        }
        commentRepository.deleteById(id);
    }
}
