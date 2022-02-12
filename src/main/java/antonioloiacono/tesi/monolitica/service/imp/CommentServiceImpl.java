package antonioloiacono.tesi.monolitica.service.imp;

import antonioloiacono.tesi.monolitica.entity.Comment;
import antonioloiacono.tesi.monolitica.repository.CommentRepository;
import antonioloiacono.tesi.monolitica.service.CommentService;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    
    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public Comment saveComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public List<Comment> findAllComments() {
        List<Comment> comments = new ArrayList<>();
        commentRepository.findAll().forEach(comments::add);
        return comments;
    }

    @Override
    public Optional<Comment> findCommentById(int id) {
        return commentRepository.findById(id);
    }

    @Override
    public void deleteComment(int id) {
        commentRepository.deleteById(id);
    }

    /*@Override
    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }*/
}
