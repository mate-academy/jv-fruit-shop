package core.basesyntax.service.impl;

import core.basesyntax.exception.InvalidDataFormatException;

import java.util.List;

public class DataValidatorService {
    private static final List<String> OPERATIONS = List.of("b", "s", "p", "r");

    public boolean isValid(String operation, String fruitName, Integer quantity) {
        if (!OPERATIONS.contains(operation)) {
            throw new InvalidDataFormatException(operation + " is invalid operation!");
        }
        if (fruitName.matches("[\\W\\d]") || fruitName.isBlank()) {
            throw new InvalidDataFormatException("Fruit name should consist any letters and special characters!");
        }
        if (quantity < 0) {
            throw new InvalidDataFormatException("The number of fruits can't be less than zero!");
        }
        return true;
    }
}
