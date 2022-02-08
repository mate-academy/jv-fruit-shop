package core.basesyntax.service.data;

import java.util.Arrays;

public class ValidatorImpl implements Validator {
    private static final int RIGHT_LENGTH = 3;
    private static final int ELEMENT_INDEX = 2;

    @Override
    public void validator(String[] datumArray) {
        if (datumArray.length != RIGHT_LENGTH
                || Integer.parseInt(datumArray[ELEMENT_INDEX]) <= 0) {
            throw new RuntimeException("Wrong data input: " + Arrays.toString(datumArray));
        }
    }
}
