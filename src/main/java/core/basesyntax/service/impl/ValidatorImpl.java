package core.basesyntax.service.impl;

import core.basesyntax.service.Validator;

public class ValidatorImpl implements Validator {
    private static final int OPERATION_INDEX = 0;
    
    @Override
    public boolean validateLine(String line) {
        String[] lineToBeChecked = line.split(",");
        if (!lineToBeChecked[OPERATION_INDEX].equals("b")
                && !lineToBeChecked[OPERATION_INDEX].equals("s")
                && !lineToBeChecked[OPERATION_INDEX].equals("p")
                && !lineToBeChecked[OPERATION_INDEX].equals("r")) {
            return false;
        }
        int quantity = 0;
        try {
            quantity = Integer.parseInt(lineToBeChecked[2]);
        } catch (NumberFormatException e) {
            return false;
        }
        if (quantity != Math.abs(quantity)) {
            return false;
        }
        return true;
    }
}
