package core.basesyntax.customexceptions;

public class NoRequiredQuantityOfFruits extends RuntimeException {
    public NoRequiredQuantityOfFruits(String message) {
        super(message);
    }
}
