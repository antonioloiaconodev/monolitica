package antonioloiacono.tesi.monolitica.entities;

//https://www.vincenzoracca.com/blog/framework/jpa/jpa-reletions
//https://www.baeldung.com/jpa-many-to-many

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import javax.persistence.*;
import java.util.Set;

@Entity
@Data //contiene tutte le annotazioni @ToString, @EqualsAndHashCode, @Getter, @Setter e @RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {
    //colonna user_id (id) primary key ed IDENTITY
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @ManyToMany
    @JoinTable(name = "users_has_videogames", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "videogame_id"))
    Set<Videogame> videogames;

    @OneToMany(mappedBy = "user") //cascade = CascadeType.ALL, orphanRemoval = true
    private Set<Rating> ratings;
}