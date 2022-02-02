package antonioloiacono.tesi.monolitica.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "ratings")
public class Rating {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "videogame_id")
    private Videogame videogame;

    private int rating;
}