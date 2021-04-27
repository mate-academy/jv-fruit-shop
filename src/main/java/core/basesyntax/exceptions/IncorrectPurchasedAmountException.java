package core.basesyntax.exceptions;

public class IncorrectPurchasedAmountException extends RuntimeException {
    public IncorrectPurchasedAmountException(String message) {
        super(message);
    }
}
