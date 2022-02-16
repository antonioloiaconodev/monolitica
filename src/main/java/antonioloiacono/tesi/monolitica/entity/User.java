package antonioloiacono.tesi.monolitica.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(length = 50, name = "first_name", nullable = false)
    private String firstName;

    @Column(length = 50, name = "last_name", nullable = false)
    private String lastName;

    @ManyToMany
    @JoinTable(name = "user_videogame", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn (name = "videogame_id", referencedColumnName = "id"))
    @JsonIgnoreProperties("users")
    private Set<Videogame> videogames = new HashSet<>();

    @OneToMany(mappedBy = "user")
    @JsonIgnoreProperties("user")
    private Set<Comment> comments = new HashSet<>();
}