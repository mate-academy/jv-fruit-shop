package core.basesyntax.service;

import core.basesyntax.service.inter.Validator;

public class FruitOperationValidator implements Validator<String> {
    private static final int QUANTITY = 2;
    private static final int MAX_LENGTH = 3;
    private static final String SEPARATOR = ",";

    @Override
    public void validate(String value) throws RuntimeException {
        if (value == null) {
            throw new RuntimeException("FruitOperation has no data. String value is null.");
        }
        String[] data = value.split(SEPARATOR);
        if (data.length != MAX_LENGTH) {
            throw new RuntimeException("Invalid value: " + value);
        }
        if (Integer.parseInt(data[QUANTITY]) < 0) {
            throw new RuntimeException("Quantity couldn't be less than 0");
        }
    }
}
