package core.basesyntax.services.implementation;

import core.basesyntax.services.Validator;

public class ValidatorImpl implements Validator {
    private static final int QUANTITY_INDEX_COLUMN = 2;
    private static final int NUMBER_OF_COLUMN = 3;
    private static final String VALIDATION_EXCEPTION = "Not enough data. Value: ";
    private static final String VALIDATION_EXCEPTION_NULL = "String value is null.";
    private static final String VALIDATION_EXCEPTION_QUANTITY = "Quantity"
            + " could not be less than 0.";

    @Override
    public void validate(String value) {
        if (value == null) {
            throw new RuntimeException(VALIDATION_EXCEPTION_NULL);
        }
        String[] data = value.split(",");
        if (data.length != NUMBER_OF_COLUMN) {
            throw new RuntimeException(VALIDATION_EXCEPTION + value);
        }
        if (Integer.parseInt(data[QUANTITY_INDEX_COLUMN]) < 0) {
            throw new RuntimeException(VALIDATION_EXCEPTION_QUANTITY + value);
        }
    }
}
