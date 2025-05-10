package core.basesyntax.exception;

public class DataFileCorruptedException extends RuntimeException {
    public DataFileCorruptedException(String message) {
        super(message);
    }
}
