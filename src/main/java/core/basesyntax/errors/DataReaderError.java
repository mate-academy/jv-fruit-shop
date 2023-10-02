package core.basesyntax.errors;

public class DataReaderError extends RuntimeException {
    public DataReaderError(String message) {
        super(message);
    }

    public DataReaderError(String message, Throwable cause) {
        super(message, cause);
    }
}
