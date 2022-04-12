package antonioloiacono.tesi.monolitica.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.util.Date;
import java.util.Set;

@Data
public class VideogameDto {
    private Long id;

    private String name;

    private String platform;

    private String genre;

    private String publisher;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date releaseDate;

    private Set<VideogameUserDto> users;
}