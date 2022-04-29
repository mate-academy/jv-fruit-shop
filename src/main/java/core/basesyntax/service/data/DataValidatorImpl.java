package core.basesyntax.service.data;

import java.util.Arrays;

public class DataValidatorImpl implements DataValidator {
    public static final int NUMBER_OF_COLUMNS = 3;

    @Override
    public void validate(String[] properArray) {
        if (properArray.length != NUMBER_OF_COLUMNS) {
            throw new RuntimeException("Invalid data format: " + Arrays.toString(properArray));
        }
    }
}
