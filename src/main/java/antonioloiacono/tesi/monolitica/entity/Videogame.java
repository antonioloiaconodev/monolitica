package antonioloiacono.tesi.monolitica.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import javax.persistence.*;
import java.util.*;

@Data
@Entity
@Table(name = "videogame")
public class Videogame {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true, length = 100, nullable = false)
    private String name;

    @Column(length = 25, nullable = false)
    private String platform;

    @Column(length = 25, nullable = false)
    private String genre;

    @Column(length = 100, nullable = false)
    private String publisher;

    @Column(name = "release_date", nullable = false)
    private Date releaseDate;

    @ManyToMany(mappedBy = "videogames")
    private Set<User> users = new HashSet<>();

    @OneToMany(mappedBy = "videogame", cascade = CascadeType.ALL)
    private Set<Comment> comments = new HashSet<>();

    public void addUser(User user) {
        this.users.add(user);
        user.getVideogames().add(this);
    }

    public void removeUser(User user) {
        this.users.remove(user);
        user.getVideogames().remove(this);
    }
}