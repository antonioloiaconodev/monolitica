package antonioloiacono.tesi.monolitica.dto;

import antonioloiacono.tesi.monolitica.entity.Comment;
import antonioloiacono.tesi.monolitica.entity.User;
import lombok.Data;
import java.util.Date;
import java.util.Set;

@Data
public class VideogameDto {
    private long id;

    private String name;

    private String platform;

    private String genre;

    private String publisher;

    private Date releaseDate;

    private Set<User> users;

    private Set<Comment> comments;
}