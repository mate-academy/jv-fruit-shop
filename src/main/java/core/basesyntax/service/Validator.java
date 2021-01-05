package core.basesyntax.service;

import core.basesyntax.model.Operation;

public class Validator {
    public static void validate(String operation) {
        if ("".equals(operation)) {
            throw new RuntimeException("Invalid line in file");
        }
        Operation.fromString(operation);
    }

    public static void validate(int quantity) {
        if (quantity < 0) {
            throw new RuntimeException("Negative quantity!");
        }
    }

    public static void validateItem(String item) {
        if ("".equals(item)) {
            throw new RuntimeException("Invalid line in file");
        }
    }
}
