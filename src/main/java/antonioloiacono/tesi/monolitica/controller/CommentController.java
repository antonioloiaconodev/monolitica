package antonioloiacono.tesi.monolitica.controller;

import antonioloiacono.tesi.monolitica.dto.CommentDTO;
import antonioloiacono.tesi.monolitica.entity.Comment;
import antonioloiacono.tesi.monolitica.exception.ResourceNotFoundException;
import antonioloiacono.tesi.monolitica.service.CommentService;
import antonioloiacono.tesi.monolitica.util.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;
    private final ModelMapper modelMapper;
    
    public CommentController(CommentService commentService, ModelMapper modelMapper) {
        this.commentService = commentService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public ResponseEntity<Comment> createComment(@Valid @RequestBody CommentDTO dto){
        Comment createdComment = commentService.saveComment(modelMapper.map(dto, Comment.class));
        return new ResponseEntity<>(createdComment, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Comment>> findAllComments(){
        return new ResponseEntity<>(commentService.findAllComments(), HttpStatus.OK);
    }

    @GetMapping("/{commentId}")
    public ResponseEntity<Comment> findCommentById(@PathVariable("commentId") int id) throws ResourceNotFoundException {
        Optional<Comment> optionalComment = commentService.findCommentById(id);
        if (optionalComment.isEmpty()) {
            throw new ResourceNotFoundException("No comment found with the id: " + id);
        }
        return new ResponseEntity<>(optionalComment.get() , HttpStatus.OK);
    }

    /*@PutMapping("/{commentId}")
    public ResponseEntity<Void> updateComment(@PathVariable("commentId") Long id, @RequestBody CommentDTO dto){
        CommentDTO commentDTO = commentService.findCommentById(id);
        if(commentDTO != null) {
            dto.setId(id);
            commentService.saveComment(dto);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<Void> deleteCommentById(@PathVariable("commentId") Long id){
        CommentDTO commentDTO = commentService.findCommentById(id);
        if(commentDTO != null) {
            commentService.deleteComment(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }*/
    
}
