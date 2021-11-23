package core.basesyntax.service.impl;

import core.basesyntax.service.Validator;

public class ValidatorImpl implements Validator {
    private static final int VALUES_QUANTITY = 3;

    @Override
    public boolean validate(String[] values) {
        if (values.length != VALUES_QUANTITY
                || values[0] == null
                || values[1] == null
                || values[2] == null
                || Integer.valueOf(values[2]) <= 0) {
            throw new RuntimeException("Wrong values");
        }
        return true;
    }
}
