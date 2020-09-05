package core.basesyntax.exeptions;

public class NotValidDataException extends RuntimeException {
    public NotValidDataException(String message) {
        super(message);
    }
}
