package core.basesyntax.errors;

public class ReportWriterError extends RuntimeException {
    public ReportWriterError(String message, Throwable cause) {
        super(message, cause);
    }
}
