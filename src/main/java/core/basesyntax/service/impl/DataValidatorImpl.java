package core.basesyntax.service.impl;

import core.basesyntax.service.DataValidator;

public class DataValidatorImpl implements DataValidator {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int NUMBER_OF_COLUMNS = 3;

    @Override
    public boolean validate(String string) {
        if (string == null) {
            throw new RuntimeException("Line from file can't be null!");
        }
        String[] strings = string.split(",");
        if (strings.length != NUMBER_OF_COLUMNS) {
            throw new RuntimeException("Line must contains 3 columns");
        }
        if (!strings[QUANTITY_INDEX].matches("[0-9]+")
                || Integer.parseInt(strings[QUANTITY_INDEX]) < 0) {
            throw new RuntimeException("File contains an invalid quantity!");
        }
        if (!strings[OPERATION_INDEX].matches("[bspr]")) {
            throw new RuntimeException("File contains an invalid operation!");
        }
        if (strings[FRUIT_INDEX].length() < 1) {
            throw new RuntimeException("File contains an invalid fruit name!");
        }
        return true;
    }
}
