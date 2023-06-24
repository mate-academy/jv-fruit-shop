package core.basesyntax.exceptions;

public class NegativeValueAmountException extends RuntimeException {
    public NegativeValueAmountException(Integer value) {
        super("Amount can not be less than 0. Amount: " + value);
    }
}
