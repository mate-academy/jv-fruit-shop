package exception;

public class IncorrectFruitTypeException extends RuntimeException {
    public IncorrectFruitTypeException(String message) {
        super(message);
    }
}
