package core.basesyntax.validation;

public class QuantityValidator implements IntegerValidator {
    public Integer check(Integer result) {
        if (result < 0) {
            throw new RuntimeException("Negative result: " + result);
        }
        return result;
    }
}
