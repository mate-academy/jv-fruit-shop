package core.basesyntax.validate.impl;

import core.basesyntax.validate.ValidationData;

public class ValidationDataImpl implements ValidationData {
    @Override
    public boolean validationData(String operation, String fruitName, String quantity) {
        validationByFruitName(fruitName);
        validationByOperation(operation);
        validationByQuantity(quantity);
        return true;
    }

    @Override
    public boolean validationByOperation(String operation) {
        if (operation.replaceAll("[b_s_p_r]", "").length() < operation.trim().length()) {
            throw new RuntimeException("Invalid operation");
        }
        return true;
    }

    @Override
    public boolean validationByFruitName(String fruitName) {
        if (fruitName.length() > fruitName.replaceAll("[^a-zA-z]", "").length()) {
            throw new RuntimeException("Invalid name");
        }
        return true;
    }

    @Override
    public boolean validationByQuantity(String quantity) {
        if (quantity.length() > quantity.replaceAll("[^0-9]", "").length()) {
            throw new RuntimeException("Invalid quantity");
        }
        return true;
    }
}
