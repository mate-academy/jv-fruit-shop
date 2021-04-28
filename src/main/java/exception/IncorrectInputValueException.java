package exception;

public class IncorrectInputValueException extends RuntimeException {
    public IncorrectInputValueException(String message) {
        super(message);
    }
}
