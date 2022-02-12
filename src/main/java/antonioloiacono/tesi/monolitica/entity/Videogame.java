package antonioloiacono.tesi.monolitica.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "videogame")
public class Videogame {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 25, nullable = false)
    private String platform;

    @Column(length = 25, nullable = false)
    private String genre;

    @Column(length = 100, nullable = false)
    private String publisher;

    @Column(name = "release_date", nullable = false)
    private Date releaseDate;

    @ManyToMany(targetEntity = User.class, mappedBy = "videogames")
   // @JsonManagedReference(value = "videogames-users")
    private List<User> users = new ArrayList<>();

    @OneToMany(targetEntity = Comment.class, mappedBy = "videogame")
    @JsonManagedReference(value = "videogame-comments")
    private List<Comment> comments = new ArrayList<>();

    public void addUser(User user) {
        this.users.add(user);
        user.getVideogames().add(this);
    }

    public void removeUser(User user) {
        this.users.remove(user);
        user.getVideogames().remove(this);
    }
}