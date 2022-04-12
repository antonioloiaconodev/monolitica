package antonioloiacono.tesi.monolitica.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "videogame")
public class Videogame {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, length = 100, nullable = false)
    private String name;

    @Column(length = 25, nullable = false)
    private String platform;

    @Column(length = 25, nullable = false)
    private String genre;

    @Column(length = 100, nullable = false)
    private String publisher;

    @Column(name = "release_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date releaseDate;

    @OneToMany(mappedBy = "videogame", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private Set<Comment> comments;

    @ManyToMany
    @JoinTable(name = "videogame_user", joinColumns = @JoinColumn(name = "videogame_id"), inverseJoinColumns = @JoinColumn (name = "user_id"))
    @JsonIgnore
    private Set<User> users;

    public void addUser(User user) {
        this.users.add(user);
        user.getVideogames().add(this);
    }

    public void removeUser(User user) {
        this.users.add(user);
        user.getVideogames().remove(this);
    }
}