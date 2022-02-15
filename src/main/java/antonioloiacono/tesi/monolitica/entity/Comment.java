package antonioloiacono.tesi.monolitica.entity;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "videogame_id", nullable = false, referencedColumnName = "id")
    private Videogame videogame;

    @Lob
    @Column(nullable = false)
    private String comment;
}