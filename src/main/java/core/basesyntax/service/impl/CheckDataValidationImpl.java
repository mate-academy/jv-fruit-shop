package core.basesyntax.service.impl;

import core.basesyntax.operationstrategy.OperationStrategy;
import core.basesyntax.service.CheckDataValidation;

public class CheckDataValidationImpl implements CheckDataValidation {
    protected static final int OPERATION_INDEX = 0;
    protected static final int FRUIT_INDEX = 1;
    protected static final int QUANTITY_INDEX = 2;
    protected static final int NUMBER_OF_COLUMNS = 3;

    @Override
    public boolean checkStringValidation(String string) {
        if (string == null) {
            throw new RuntimeException("Line from file can't be null!");
        }
        String[] strings = string.split(",");
        if (strings.length != NUMBER_OF_COLUMNS) {
            throw new RuntimeException("Line must contains 3 columns");
        }
        try {
            int quantity = Integer.parseInt(strings[QUANTITY_INDEX]);
        } catch (NumberFormatException e) {
            throw new RuntimeException("File contains an invalid quantity!");
        }
        if (Integer.parseInt(strings[QUANTITY_INDEX]) < 0) {
            throw new RuntimeException("File contains an invalid quantity!");
        }
        if (!OperationStrategy.MAP_OPERATION.containsKey(strings[OPERATION_INDEX])) {
            throw new RuntimeException("File contains an invalid operation!");
        }
        if (strings[FRUIT_INDEX].length() < 1) {
            throw new RuntimeException("File contains an invalid fruit name!");
        }
        return true;
    }
}
