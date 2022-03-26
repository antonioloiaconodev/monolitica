package antonioloiacono.tesi.monolitica.service;

import antonioloiacono.tesi.monolitica.dto.CommentCreateDto;
import antonioloiacono.tesi.monolitica.dto.CommentDto;
import antonioloiacono.tesi.monolitica.dto.CommentUpdateDto;
import java.util.Set;

public interface CommentService {

    Set<CommentDto> findAllComments();

    CommentDto findCommentById(Long id);

    CommentDto createComment(CommentCreateDto commentCreateDto);

    CommentDto updateComment(Long id, CommentUpdateDto commentUpdateDto);

    void deleteComment(Long id);
}
