package exception;

public class FruitStorageException extends RuntimeException {
    public FruitStorageException(String message) {
        super(message);
    }

    public FruitStorageException(String message, Throwable cause) {
        super(message, cause);
    }
}
