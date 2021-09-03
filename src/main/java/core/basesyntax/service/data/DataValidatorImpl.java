package core.basesyntax.service.data;

import java.util.Arrays;

public class DataValidatorImpl implements DataValidator {
    @Override
    public void validate(String[] datumArray) {
        if (datumArray.length != 3 || Integer.parseInt(datumArray[2]) <= 0) {
            throw new RuntimeException("Wrong data input: " + Arrays.toString(datumArray));
        }
    }
}
