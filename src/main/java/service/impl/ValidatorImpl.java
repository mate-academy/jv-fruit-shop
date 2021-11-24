package service.impl;

import service.Validator;

public class ValidatorImpl implements Validator {
    private static final String LINE_MATCHER_REGEX = "[bspr],[a-zA-Z]+,[0-9]+";
    private static final int OPERATION_TYPE_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int FRUIT_AMOUNT_INDEX = 2;

    @Override
    public boolean validate(String line) {
        if (line.isEmpty()) {
            throw new RuntimeException("Empty line in inputFile");
        }
        if (line.matches(LINE_MATCHER_REGEX)) {
            return true;
        }
        throw new RuntimeException("invalid value in inputFile");
    }
}
