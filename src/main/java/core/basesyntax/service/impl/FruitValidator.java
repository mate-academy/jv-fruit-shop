package core.basesyntax.service.impl;

import core.basesyntax.service.Validator;

public class FruitValidator implements Validator {
    private static final String FRUIT_VALIDATION_REGEX = "[bspr],\\w+,\\d+";

    @Override
    public boolean isValid(String line) {
        return line.matches(FRUIT_VALIDATION_REGEX);
    }
}
