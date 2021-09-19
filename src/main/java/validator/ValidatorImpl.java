package validator;

import java.util.List;

public class ValidatorImpl implements Validator {
    private static final int NUMBER_OF_COLUMN = 3;
    private static final int QUANTITY_COLUMN = 2;

    @Override
    public boolean isValidLine(String line) {
        String[] oneLine = line.split(",");
        if(oneLine.length != NUMBER_OF_COLUMN
        || Integer.parseInt(oneLine[QUANTITY_COLUMN]) < 0 ) {
            throw new RuntimeException("Line have mistakes");
        }
        return true;
    }
}
