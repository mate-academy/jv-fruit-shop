package core.basesyntax.service;

public class AmountValidatorImpl implements AmountValidator {
    @Override
    public boolean compare(Integer value, Integer amount) {
        return value >= amount;
    }
}
