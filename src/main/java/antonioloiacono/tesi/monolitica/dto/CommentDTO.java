package antonioloiacono.tesi.monolitica.dto;

import lombok.Data;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class CommentDTO {
    @NotNull(message = "The user's Id is required.")
    @Positive(message = "The user's Id must be greater than 0")
    private int userId;

    @NotNull(message = "The videogame's Id is required.")
    @Positive(message = "The videogame's Id must be greater than 0")
    private int videogameId;

    @NotNull(message = "The comment is required.")
    private String comment;
}