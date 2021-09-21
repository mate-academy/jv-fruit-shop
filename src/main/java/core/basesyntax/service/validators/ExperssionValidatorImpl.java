package core.basesyntax.service.validators;

public class ExperssionValidatorImpl implements ExpessionValidator {
    @Override
    public void validateExpression(Integer i1, Integer i2) {
        if (i1 - i2 < 0) {
            throw new RuntimeException("input data is invalid");
        }
    }
}
