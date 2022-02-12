package antonioloiacono.tesi.monolitica.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class UserUpdateDTO {
    @Email(message = "The email address is invalid.", flags = { Pattern.Flag.CASE_INSENSITIVE })
    private String email;

    private String password;

    @Size(min = 2, max = 50, message = "The length of first name must be between 2 and 50 characters.")
    private String firstName;

    @Size(min = 2, max = 50, message = "The length of last name must be between 2 and 50 characters.")
    private String lastName;
}