package core.basesyntax.service;

import core.basesyntax.exceptions.InvalidOperationException;
import core.basesyntax.interfaces.DataLineValidator;

public class DataLineLineValidatorImpl implements DataLineValidator {
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int VALID_LINE_PARTS = 3;

    @Override
    public void dataCheck(String[] data) {
        if (data.length != VALID_LINE_PARTS) {
            throw new InvalidOperationException("Wrong operation input");
        }
        String fruit = data[FRUIT_NAME_INDEX];
        if (fruit == null || fruit.isEmpty()) {
            throw new InvalidOperationException("Fruit name can`t be null");
        }
        if (!fruit.matches("\\w\\D\\S+")) {
            throw new InvalidOperationException("Incorrect fruit name " + fruit);
        }
        if (!data[QUANTITY_INDEX].matches("[0-9]+")) {
            throw new InvalidOperationException(
                    String.format("Quantity should ba a positive number, provided \""
                            + data[QUANTITY_INDEX] + "\""));
        }
    }
}
