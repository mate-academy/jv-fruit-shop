package core.basesyntax.service.validator;

import java.util.Arrays;

public class ValidatorImpl implements Validator {
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;
    private static final int FRUIT_RECORD_LENGTH = 3;

    @Override
    public boolean validate(String[] fruitRecord) {
        if (fruitRecord.length != FRUIT_RECORD_LENGTH
                || fruitRecord[FRUIT_INDEX].isEmpty()
                || Integer.parseInt(fruitRecord[AMOUNT_INDEX]) < 0) {
            throw new RuntimeException("Incorrect record of data " + Arrays.toString(fruitRecord));
        }
        return true;
    }
}
