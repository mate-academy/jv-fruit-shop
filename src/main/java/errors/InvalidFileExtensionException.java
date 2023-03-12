package errors;

public class InvalidFileExtensionException extends RuntimeException {
    public InvalidFileExtensionException(String message) {
        super(message);
    }
}
