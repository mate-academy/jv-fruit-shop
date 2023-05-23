package core.basesyntax.validation;

public class StrategyValidator {
    public int check(int result) {
        if (result < 0) {
            throw new RuntimeException("Negative result: " + result);
        }
        return result;
    }
}
