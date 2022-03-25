package antonioloiacono.tesi.monolitica.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import javax.validation.constraints.*;
import java.util.Date;

@Data
public class VideogameCreateDto {
    @NotEmpty(message = "The name is required.")
    @Size(min = 2, max = 100, message = "The length of name must be between 2 and 100 characters.")
    private String name;

    @NotEmpty(message = "The platform is required.")
    @Size(min = 2, max = 25, message = "The length of platform must be between 2 and 25 characters.")
    private String platform;

    @NotEmpty(message = "The genre is required.")
    @Size(min = 2, max = 25, message = "The length of genre must be between 2 and 25 characters.")
    private String genre;

    @NotEmpty(message = "The publisher is required.")
    @Size(min = 2, max = 100, message = "The length of publisher must be between 2 and 100 characters.")
    private String publisher;

    @NotNull(message = "The release date is required.")
    @Past(message = "The release date must be in the past.")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date releaseDate;
}
