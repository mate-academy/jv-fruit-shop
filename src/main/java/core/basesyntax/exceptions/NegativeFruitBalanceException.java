package core.basesyntax.exceptions;

public class NegativeFruitBalanceException extends RuntimeException {
    public NegativeFruitBalanceException(String message) {
        super(message);
    }
}
