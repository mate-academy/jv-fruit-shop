package core.basesyntax.errors;

public class DaoError extends RuntimeException {
    public DaoError(String message) {
        super(message);
    }
}
