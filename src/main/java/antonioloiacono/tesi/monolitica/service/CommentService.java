package antonioloiacono.tesi.monolitica.service;

import antonioloiacono.tesi.monolitica.dto.CommentDTO;
import antonioloiacono.tesi.monolitica.entity.Comment;
import antonioloiacono.tesi.monolitica.exception.RecordNotFoundException;
import java.util.Set;

public interface CommentService {
    Comment saveComment(CommentDTO dto) throws RecordNotFoundException;

    Comment updateComment(int id, CommentDTO dto) throws RecordNotFoundException;

    Set<Comment> findAllComments() throws RecordNotFoundException;

    Comment findCommentById(int id) throws RecordNotFoundException;

    void deleteComment(int id) throws RecordNotFoundException;
}
