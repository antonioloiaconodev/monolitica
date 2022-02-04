package antonioloiacono.tesi.monolitica.dto;

import antonioloiacono.tesi.monolitica.model.Rating;
import antonioloiacono.tesi.monolitica.model.Videogame;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor

public class UserDTO {

    private Long id;

    private String username;

    private String firstName;

    private String lastName;

    private List<Videogame> videogames;

    //private List<Rating> ratings;

}
