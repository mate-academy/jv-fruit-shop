package core.basesyntax.service.impl;

import core.basesyntax.service.Validator;

public class ValidatorImpl implements Validator {
    @Override
    public boolean validateLine(String line) {
        String[] lineToBeChecked = line.split(",");
        if (!lineToBeChecked[0].equals("b")
                && !lineToBeChecked[0].equals("s")
                && !lineToBeChecked[0].equals("p")
                && !lineToBeChecked[0].equals("r")) {
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
