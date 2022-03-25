package antonioloiacono.tesi.monolitica.dto;

import javax.validation.constraints.*;
import lombok.Data;

@Data
public class UserCreateDto {
    @NotEmpty(message = "The email address is required.")
    @Email(message = "The email address is invalid.", flags = { Pattern.Flag.CASE_INSENSITIVE })
    private String email;

    @NotEmpty(message = "The first name is required.")
    @Size(min = 2, max = 50, message = "The length of first name must be between 2 and 50 characters.")
    private String firstName;

    @NotEmpty(message = "The last name is required.")
    @Size(min = 2, max = 50, message = "The length of last name must be between 2 and 50 characters.")
    private String lastName;
}