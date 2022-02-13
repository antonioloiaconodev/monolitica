package antonioloiacono.tesi.monolitica.exception;

public class ResourceAlreadyExistsException extends RuntimeException {
    private String message;

    public ResourceAlreadyExistsException(String message) {
        super(message);
        this.message = message;
    }
}