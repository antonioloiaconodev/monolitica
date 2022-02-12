package antonioloiacono.tesi.monolitica.service;

import antonioloiacono.tesi.monolitica.entity.Comment;
import java.util.List;
import java.util.Optional;

public interface CommentService {

    Comment saveComment(Comment comment);

    List<Comment> findAllComments();

    Optional<Comment> findCommentById(int id);

    void deleteComment(int id);
}
