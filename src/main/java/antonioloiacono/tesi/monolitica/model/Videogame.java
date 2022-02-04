package antonioloiacono.tesi.monolitica.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.ALL}) //cascade = {CascadeType.MERGE, CascadeType.REFRESH}
    @JoinTable(
            name = "users_videogames",
            joinColumns = @JoinColumn(name = "videogame_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn (name = "user_id", referencedColumnName = "id")
    )
    private List<User> users;

   // @OneToMany(mappedBy = "videogame")
   // private List<Rating> ratings;
}
