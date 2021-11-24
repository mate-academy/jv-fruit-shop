package core.basesyntax.service.impl;

import core.basesyntax.service.Validator;

public class ValidatorImpl implements Validator {
    private static final int OPERATION = 0;
    private static final int FRUIT_NAME = 1;
    private static final int QUANTITY = 2;
    private static final int NUMBER_OF_PARAMETERS = 3;

    @Override
    public boolean validate(String line) {
        String[] oneLineData = line.split(",");
        if (oneLineData[OPERATION].matches("[bspr]")
                && !oneLineData[FRUIT_NAME].isEmpty()
                && !oneLineData[QUANTITY].isEmpty()
                && Integer.parseInt(oneLineData[QUANTITY]) > 0
                && oneLineData.length == NUMBER_OF_PARAMETERS) {
            return true;
        }
        return false;
    }
}
