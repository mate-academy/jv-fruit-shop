package core.basesyntax.exception;

public class NegativeAmountInStorageException extends RuntimeException {
    public NegativeAmountInStorageException(String message) {
        super(message);
    }
}
