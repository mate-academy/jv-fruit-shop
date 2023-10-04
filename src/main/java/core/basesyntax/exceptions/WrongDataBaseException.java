package core.basesyntax.exceptions;

public class WrongDataBaseException extends RuntimeException {
    public WrongDataBaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongDataBaseException(String message) {
        super(message);
    }
}
