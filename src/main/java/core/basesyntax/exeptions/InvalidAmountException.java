package core.basesyntax.exeptions;

public class InvalidAmountException extends RuntimeException {
    public InvalidAmountException() {
        super("Amount is invalid");
    }
}
