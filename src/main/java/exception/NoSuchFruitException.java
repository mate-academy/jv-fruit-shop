package exception;

public class NoSuchFruitException extends RuntimeException {
    public NoSuchFruitException(String message) {
        super(message);
    }
}
