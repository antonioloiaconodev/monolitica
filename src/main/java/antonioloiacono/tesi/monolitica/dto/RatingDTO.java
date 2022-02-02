package antonioloiacono.tesi.monolitica.dto;

import antonioloiacono.tesi.monolitica.model.User;
import antonioloiacono.tesi.monolitica.model.Videogame;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor

public class RatingDTO {

    private User user;

    private Videogame videogame;

    private int rating;
}