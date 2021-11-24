package core.basesyntax.service.impl;

import core.basesyntax.service.Validator;

public class ValidatorImpl implements Validator {
    private static byte OPERATION_INDEX = 0;
    private static byte FRUIT_NAME_INDEX = 1;
    private static byte QUANTITY_INDEX = 2;
    private static byte LENGTH_OF_DATA_ARRAY = 3;

    @Override
    public boolean validate(String line) {
        String[] parametersFromLine = line.split(",");
        String type = parametersFromLine[OPERATION_INDEX];
        if (parametersFromLine.length != LENGTH_OF_DATA_ARRAY) {
            throw new RuntimeException("Invalid date");
        }
        if (!(type.equals("b")
                || type.equals("s")
                || type.equals("p")
                || type.equals("r"))) {
            throw new RuntimeException("Invalid type of activities");
        }
        if (!parametersFromLine[FRUIT_NAME_INDEX].matches("[a-zA-Z]*")) {
            throw new RuntimeException("Invalid name of fruit");
        }
        if (!parametersFromLine[QUANTITY_INDEX].matches("[0-9]*")) {
            throw new RuntimeException("Invalid quantity of fruit, should be numbers");
        }
        if (Integer.parseInt(parametersFromLine[QUANTITY_INDEX]) < 0) {
            throw new RuntimeException("Invalid quantity of fruit, "
                    + "quantity should be more than zero");
        }
        return true;
    }
}
