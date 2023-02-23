package core.basesyntax.exception;

public class ReportMakerException extends RuntimeException {
    public ReportMakerException(String message) {
        super(message);
    }

    public ReportMakerException(String message, Throwable cause) {
        super(message, cause);
    }
}
