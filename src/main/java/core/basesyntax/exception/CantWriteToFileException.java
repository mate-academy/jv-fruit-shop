package core.basesyntax.exception;

public class CantWriteToFileException extends RuntimeException {

    public CantWriteToFileException(String message) {
        super(message);
    }
}
