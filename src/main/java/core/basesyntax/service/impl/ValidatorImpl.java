package core.basesyntax.service.impl;

import core.basesyntax.service.Validator;

public class ValidatorImpl implements Validator {
    private static final int INDEX_OF_OPERATION = 0;
    private static final int INDEX_OF_FRUIT = 1;
    private static final int INDEX_OF_AMOUNT = 2;

    @Override
    public void validate(String[] line) {
        if (line[INDEX_OF_OPERATION].length() > 0
                && line[INDEX_OF_FRUIT].matches("\\w+")
                && line[INDEX_OF_AMOUNT].matches("\\d+")) {
            return;
        }
        throw new RuntimeException("Invalid input data, check your activities");
    }
}
