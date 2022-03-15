package core.basesyntax.exceptions;

public class WrongQuantityException extends IllegalArgumentException {
    public WrongQuantityException() {
        super("Quantity must be a positive number, not less than or equal to 0");
    }
}
