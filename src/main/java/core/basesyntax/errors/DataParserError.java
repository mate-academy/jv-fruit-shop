package core.basesyntax.errors;

public class DataParserError extends RuntimeException {
    public DataParserError(String message) {
        super(message);
    }

    public DataParserError(String message, Throwable cause) {
        super(message, cause);
    }
}
