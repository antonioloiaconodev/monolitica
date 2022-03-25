package antonioloiacono.tesi.monolitica.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    private Date releaseDate;

    @ManyToMany(mappedBy = "videogames")
    @JsonIgnore
    private Set<User> users;

    @OneToMany(mappedBy = "videogame")
    @JsonIgnore
    private Set<Comment> comments;
}