package core.basesyntax.service.impl;

import core.basesyntax.service.DataValidation;

public class DataValidationImpl implements DataValidation {
    private static final String VALID_REGEX = "[bspr],[a-z]+,[0-9]+";

    @Override
    public boolean checkLine(String line) {
        return line.matches(VALID_REGEX);
    }

    @Override
    public boolean subtractCheck(int currentQuantity, int subtract) {
        if (currentQuantity < subtract) {
            throw new RuntimeException("Can't subtract more than current quantity");
        }
        return true;
    }
}
