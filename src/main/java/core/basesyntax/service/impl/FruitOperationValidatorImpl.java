package core.basesyntax.service.impl;

import core.basesyntax.service.FruitOperationValidator;

public class FruitOperationValidatorImpl implements FruitOperationValidator {
    private static final int AMOUNT_INDEX = 2;
    private static final int NUMBER_OF_FIELDS_IN_ONE_LINE = 3;

    @Override
    public void validate(String[] data) {
        int dataLength = data.length;
        int fruitsQuantity = Integer.parseInt(data[AMOUNT_INDEX]);
        if (dataLength != NUMBER_OF_FIELDS_IN_ONE_LINE) {
            throw new RuntimeException("There should be " + NUMBER_OF_FIELDS_IN_ONE_LINE
                + " fields in one line, but was: " + dataLength + ".");
        }
        if (fruitsQuantity <= 0) {
            throw new RuntimeException("Quantity of fruits must be positive, but was: "
                    + fruitsQuantity + ".");
        }
    }
}
