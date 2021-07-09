package core.basesyntax.service;

import java.util.Arrays;

public class DataValidatorImpl implements DataValidator {
    private static final int QUANTITY_OF_NEEDED_ELEMENT = 3;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public boolean isValid(String[] data) {
        if (data.length != QUANTITY_OF_NEEDED_ELEMENT
                || data[FRUIT_NAME_INDEX].isEmpty()
                || Integer.parseInt(data[QUANTITY_INDEX]) < 0) {
            throw new RuntimeException("The input data is invalid " + Arrays.toString(data));
        }
        return true;
    }
}
