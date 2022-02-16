package antonioloiacono.tesi.monolitica.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, referencedColumnName = "id")
    @JsonIgnoreProperties("comments")
    private User user;

    @ManyToOne
    @JoinColumn(name = "videogame_id", nullable = false, referencedColumnName = "id")
    @JsonIgnoreProperties("comments")
    private Videogame videogame;

    @Lob
    @Column(nullable = false)
    private String comment;
}