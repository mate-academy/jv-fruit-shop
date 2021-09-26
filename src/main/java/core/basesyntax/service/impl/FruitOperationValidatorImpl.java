package core.basesyntax.service.impl;

import core.basesyntax.service.FruitOperationValidator;
import java.util.Arrays;

public class FruitOperationValidatorImpl implements FruitOperationValidator {
    private static final int AMOUNT = 2;
    private static final int REQUIRED_LENGTH = 3;
    private static final String MESSAGE = "Input data is incorrect: ";

    @Override
    public void validate(String[] data) {
        if (data.length != REQUIRED_LENGTH || Integer.parseInt(data[AMOUNT]) <= 0) {
            throw new RuntimeException(MESSAGE + Arrays.toString(data));
        }
    }
}
