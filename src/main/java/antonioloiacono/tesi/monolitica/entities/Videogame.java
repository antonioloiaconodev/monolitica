package antonioloiacono.tesi.monolitica.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "videogames")
public class Videogame {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String platform;
    private String genre;
    private String publisher;
    private String release;

    @ManyToMany(mappedBy = "videogames")
    private Set<User> users;

    @OneToMany(mappedBy = "videogame")
    private Set<Rating> ratings;
}
