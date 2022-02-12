package antonioloiacono.tesi.monolitica.repository;

import antonioloiacono.tesi.monolitica.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {}
