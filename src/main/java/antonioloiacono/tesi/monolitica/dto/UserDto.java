package antonioloiacono.tesi.monolitica.dto;

import antonioloiacono.tesi.monolitica.entity.Comment;
import antonioloiacono.tesi.monolitica.entity.Videogame;
import lombok.Data;
import java.util.Set;

@Data
public class UserDto {
    private long id;

    private String email;

    private String firstName;

    private String lastName;

    private Set<Videogame> videogames;

    private Set<Comment> comments;
}