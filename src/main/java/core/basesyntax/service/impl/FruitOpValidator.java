package core.basesyntax.service.impl;

import core.basesyntax.ValidationException;
import core.basesyntax.service.interfaces.FileValidator;

public class FruitOpValidator implements FileValidator<String> {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String CSV_SEPARATOR = ",";
    private static final int ARRAY_LENGTH = 3;

    @Override
    public void validate(String value) throws ValidationException {
        if (value == null) {
            throw new ValidationException("Input value is null");
        }
        String[] split = value.split(CSV_SEPARATOR);
        if (split.length != ARRAY_LENGTH) {
            throw new ValidationException("Data is missing");
        }
        if (Integer.parseInt(split[QUANTITY_INDEX]) < 0) {
            throw new ValidationException("Quantity cannot be negative");
        }
    }
}
