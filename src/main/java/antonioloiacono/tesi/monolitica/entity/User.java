package antonioloiacono.tesi.monolitica.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(length = 50, name = "first_name", nullable = false)
    private String firstName;

    @Column(length = 50, name = "last_name", nullable = false)
    private String lastName;

    @ManyToMany(targetEntity = Videogame.class, cascade = CascadeType.REMOVE)
    @JoinTable(name = "user_videogame", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn (name = "videogame_id", referencedColumnName = "id"))
    @JsonBackReference(value = "videogames-users")
    private List<Videogame> videogames = new ArrayList<>();

    @OneToMany(targetEntity = Comment.class, mappedBy = "user")
    @JsonManagedReference(value = "user-comments")
    private List<Comment> comments = new ArrayList<>();
}