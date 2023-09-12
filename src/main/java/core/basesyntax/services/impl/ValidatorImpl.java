package core.basesyntax.services.impl;

import core.basesyntax.services.OperationHandler;
import core.basesyntax.services.Validator;
import java.util.List;

public class ValidatorImpl implements Validator {
    private static final int OPERATION = 0;
    private static final int FRUIT_NAME = 1;
    private static final int QUANTITY = 2;
    private static final int SIZE_TRANSLATION = 3;
    private static final int ZERO = 0;
    private static final String COMMA = ",";

    @Override
    public boolean checkOperation(int money) {
        if (money < ZERO) {
            throw new RuntimeException("Incorrect input data");
        }
        return true;
    }

    @Override
    public boolean checkInputData(List<String> listData) {
        for (String row : listData) {
            if (!checkInputRowData(row.split(COMMA))) {
                return false;
            }
        }
        return true;
    }

    private boolean checkInputRowData(String[] data) {
        OperationHandler.findOperation(data[OPERATION]);
        if (data.length != SIZE_TRANSLATION
                || data[FRUIT_NAME].isBlank()
                || Integer.parseInt(data[QUANTITY]) < 0
                || data[OPERATION].length() != 1) {
            throw new RuntimeException("Incorrect input data");
        }
        return true;
    }
}
