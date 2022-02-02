package antonioloiacono.tesi.monolitica.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "videogames")
public class Videogame {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String platform;
    private String genre;
    private String publisher;
    private Date release;

    @ManyToMany(mappedBy = "videogames")
    private List<User> users;

    @OneToMany(mappedBy = "videogame")
    private List<Rating> ratings;
}
