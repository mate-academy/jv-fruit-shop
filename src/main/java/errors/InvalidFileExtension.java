package errors;

public class InvalidFileExtension extends RuntimeException {
    public InvalidFileExtension(String message) {
        super(message);
    }
}
