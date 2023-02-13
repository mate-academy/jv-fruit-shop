package core.basesyntax.service.data;

import java.util.Arrays;

public class DataValidatorImpl implements DataValidator {
    public static final int NUMBER_OF_COLUMNS = 3;
    public static final int INDEX_OF_AMOUNT = 2;

    @Override
    public void validate(String[] datumArray) {
        if (datumArray.length != NUMBER_OF_COLUMNS
                || Integer.parseInt(datumArray[INDEX_OF_AMOUNT]) <= 0) {
            throw new RuntimeException("Wrong data input: " + Arrays.toString(datumArray));
        }
    }
}
