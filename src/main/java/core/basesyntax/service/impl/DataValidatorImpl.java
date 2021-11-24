package core.basesyntax.service.impl;

import core.basesyntax.operationstrategy.OperationStrategy;
import core.basesyntax.service.DataValidator;

public class DataValidatorImpl implements DataValidator {
    protected static final int OPERATION_INDEX = 0;
    protected static final int FRUIT_INDEX = 1;
    protected static final int QUANTITY_INDEX = 2;
    protected static final int NUMBER_OF_COLUMNS = 3;

    @Override
    public boolean validate(String string) {
        if (string == null) {
            throw new RuntimeException("Line from file can't be null!");
        }
        String[] strings = string.split(",");
        if (strings.length != NUMBER_OF_COLUMNS) {
            throw new RuntimeException("Line must contains 3 columns");
        }
        if (strings[QUANTITY_INDEX].replaceAll("[0-9]","").length() != 0
                || Integer.parseInt(strings[QUANTITY_INDEX]) < 0) {
            throw new RuntimeException("File contains an invalid quantity!");
        }
        if (!OperationStrategy.mapOperation.containsKey(strings[OPERATION_INDEX])) {
            throw new RuntimeException("File contains an invalid operation!");
        }
        if (strings[FRUIT_INDEX].length() < 1) {
            throw new RuntimeException("File contains an invalid fruit name!");
        }
        return true;
    }
}
