package service.data;

import java.util.Arrays;

public class DataValidatorImpl implements DataValidator {
    public static final int MAX_COLUMNS = 3;
    public static final int QUANTITY = 2;

    @Override
    public void validate(String[] datumArray) {
        if (datumArray.length != MAX_COLUMNS
                || Integer.parseInt(datumArray[QUANTITY]) <= 0) {
            throw new RuntimeException("Wrong data input: " + Arrays.toString(datumArray));
        }
    }
}
