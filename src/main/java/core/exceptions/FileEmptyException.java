package core.exceptions;

public class FileEmptyException extends RuntimeException {
    public FileEmptyException(String message, Throwable cause) {
        super(message);
    }
}
