package antonioloiacono.tesi.monolitica.controller;

import antonioloiacono.tesi.monolitica.dto.CommentDTO;
import antonioloiacono.tesi.monolitica.entity.Comment;
import antonioloiacono.tesi.monolitica.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("/comments")
public class CommentController {
    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public ResponseEntity<Comment> createComment(@Valid @RequestBody CommentDTO req) {
        return new ResponseEntity<>(commentService.saveComment(req), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Set<Comment>> findAllComments() {
        return new ResponseEntity<>(commentService.findAllComments(), HttpStatus.OK);
    }

    @GetMapping("/{commentId}")
    public ResponseEntity<Comment> findCommentById(@PathVariable("commentId") int id) {
        return new ResponseEntity<>(commentService.findCommentById(id) , HttpStatus.OK);
    }

    @PutMapping("/{commentId}")
    public ResponseEntity<Comment> updateComment(@PathVariable("commentId") int id, @Valid @RequestBody CommentDTO req) {
        return new ResponseEntity<>(commentService.updateComment(id, req), HttpStatus.OK);
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<Void> deleteCommentById(@PathVariable("commentId") int id) {
        commentService.deleteComment(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
