package core.basesyntax.service.impl;

import core.basesyntax.exception.InvalidDataFormatException;
import core.basesyntax.exception.InvalidOperationException;
import java.util.List;

public class DataValidatorService {
    private static final List<String> OPERATIONS = List.of("b", "s", "p", "r");

    public boolean isValid(String operation, String fruitName, Integer quantity) {
        return isValidOperation(operation)
                && isValidFruitName(fruitName)
                && isValidQuantity(quantity);
    }

    public boolean isValidQuantityToPurchase(Integer currentQuantity, Integer requiredQuantity) {
        if (currentQuantity < requiredQuantity) {
            throw new InvalidOperationException("The required quantity " + requiredQuantity
                                                + " can't be sold, since the current quantity "
                                                + currentQuantity);

        }
        return true;
    }

    private boolean isValidOperation(String operation) {
        if (!OPERATIONS.contains(operation)) {
            throw new InvalidDataFormatException(operation + " is invalid operation!");
        }
        return true;
    }

    private boolean isValidFruitName(String name) {
        if (name.matches("[\\W\\d]") || name.isBlank()) {
            throw new InvalidDataFormatException("Fruit name should consist "
                                                    + "any letters and special characters!");
        }
        return true;
    }

    private boolean isValidQuantity(Integer quantity) {
        if (quantity < 0) {
            throw new InvalidDataFormatException("The number of fruits can't be less than zero!");
        }
        return true;
    }
}
