package antonioloiacono.tesi.monolitica.model;

//https://www.vincenzoracca.com/blog/framework/jpa/jpa-reletions
//https://www.baeldung.com/jpa-many-to-many

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.List;

@Entity
@Data //contiene tutte le annotazioni @ToString, @EqualsAndHashCode, @Getter, @Setter e @RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor

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

    @JsonIgnore
    @ManyToMany(mappedBy = "users", cascade = CascadeType.ALL) //cascade = {CascadeType.MERGE, CascadeType.REFRESH},
    //@NotFound(action = NotFoundAction.IGNORE)
    private List<Videogame> videogames;

    //@OneToMany(mappedBy = "user") //cascade = CascadeType.ALL, orphanRemoval = true
    //private List<Rating> ratings;
}
