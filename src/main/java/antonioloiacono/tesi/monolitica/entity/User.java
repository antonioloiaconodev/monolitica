package antonioloiacono.tesi.monolitica.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(length = 50, name = "first_name", nullable = false)
    private String firstName;

    @Column(length = 50, name = "last_name", nullable = false)
    private String lastName;

    @ManyToMany
    @JoinTable(name = "user_videogame", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn (name = "videogame_id"))
    @JsonIgnore
    private Set<Videogame> videogames;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private Set<Comment> comments;

    public void addVideogame(Videogame videogame) {
        this.videogames.add(videogame);
        videogame.getUsers().add(this);
    }

    public void removeVideogame(Videogame videogame) {
        this.videogames.remove(videogame);
        videogame.getUsers().remove(this);
    }

    //TODO https://www.javainuse.com/devOps/docker/docker-mysql
}