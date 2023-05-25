package core.basesyntax.exeptions;

public class InvalidTransaction extends RuntimeException {
    public InvalidTransaction(String message) {
        super(message);
    }
}
