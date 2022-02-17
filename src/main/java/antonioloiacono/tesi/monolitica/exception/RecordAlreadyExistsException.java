package antonioloiacono.tesi.monolitica.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class RecordAlreadyExistsException extends RuntimeException {
    public RecordAlreadyExistsException(String exception) {
        super(exception);
    }
}