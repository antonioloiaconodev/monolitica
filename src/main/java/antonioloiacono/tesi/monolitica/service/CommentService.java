package antonioloiacono.tesi.monolitica.service;

import antonioloiacono.tesi.monolitica.dto.CommentDTO;
import antonioloiacono.tesi.monolitica.entity.Comment;
import antonioloiacono.tesi.monolitica.exception.ResourceNotFoundException;
import java.util.Set;

public interface CommentService {
    Comment saveComment(CommentDTO dto) throws ResourceNotFoundException;

    Comment updateComment(int id, CommentDTO dto) throws ResourceNotFoundException;

    Set<Comment> findAllComments() throws ResourceNotFoundException;

    Comment findCommentById(int id) throws ResourceNotFoundException;

    void deleteComment(int id) throws ResourceNotFoundException;
}
