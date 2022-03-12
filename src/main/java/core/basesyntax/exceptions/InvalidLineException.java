package core.basesyntax.exceptions;

public class InvalidLineException extends RuntimeException {
    public InvalidLineException() {
        super("Line must contain 3 and only 3 separate elements: "
                + "operation letter, fruit name and their quantity");
    }

    public InvalidLineException(String message) {
        super(message);
    }
}
