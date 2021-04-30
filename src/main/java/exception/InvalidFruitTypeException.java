package exception;

public class InvalidFruitTypeException extends RuntimeException {
    public InvalidFruitTypeException(String message) {
        super(message);
    }
}
