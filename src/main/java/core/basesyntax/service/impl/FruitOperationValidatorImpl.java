package core.basesyntax.service.impl;

import core.basesyntax.service.FruitOperationValidator;
import java.util.Arrays;

public class FruitOperationValidatorImpl implements FruitOperationValidator {
    private static final int AMOUNT_INDEX = 2;
    private static final int DATA_LENGTH = 3;

    @Override
    public void validate(String[] data) {
        if (data.length != DATA_LENGTH || Integer.parseInt(data[AMOUNT_INDEX]) <= 0) {
            throw new RuntimeException("Input data is incorrect: " + Arrays.toString(data));
        }
    }
}
