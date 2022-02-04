package antonioloiacono.tesi.monolitica.dto;

import antonioloiacono.tesi.monolitica.model.Rating;
import antonioloiacono.tesi.monolitica.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.sql.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor

public class VideogameDTO {

    private Long id;

    private String name;

    private String platform;

    private String genre;

    private String publisher;

    private Date release;

    private List<User> users;

    //private List<Rating> ratings;
}
