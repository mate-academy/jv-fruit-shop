package exception;

public class FileException extends RuntimeException {
    public FileException(String message, Throwable cause) {
        super(message, cause);
    }
}
