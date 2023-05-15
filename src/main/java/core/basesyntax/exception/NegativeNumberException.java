package core.basesyntax.exception;

public class NegativeNumberException extends RuntimeException {
    public NegativeNumberException() {
        super("Number can't be 0 or less than 0");
    }
}
