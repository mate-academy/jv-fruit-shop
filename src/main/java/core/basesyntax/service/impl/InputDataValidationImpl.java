package core.basesyntax.service.impl;

import core.basesyntax.service.InputDataValidation;

public class InputDataValidationImpl implements InputDataValidation {

    public int validate(String reportQuantity) {
        try {
            return Integer.parseInt(reportQuantity);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Quantity must be a number, now is: " + reportQuantity,e);
        }
    }
}

