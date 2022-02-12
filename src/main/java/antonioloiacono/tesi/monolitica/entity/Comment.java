package antonioloiacono.tesi.monolitica.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne(targetEntity = User.class, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "user_id", nullable = false, referencedColumnName = "id")
    @JsonBackReference(value = "user-comments")
    private User user;

    @ManyToOne(targetEntity = Videogame.class, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "videogame_id", nullable = false, referencedColumnName = "id")
    @JsonBackReference(value = "videogame-comments")
    private Videogame videogame;

    @Lob
    @Column(nullable = false)
    private String comment;
}