package core.basesyntax.service;

import core.basesyntax.model.Operation;

public class Validator {
    public static void validate(String operation) {
        Operation.fromString(operation);
    }

    public static void validate(int quantity) {
        if (quantity < 0) {
            throw new RuntimeException("Negative quantity!");
        }
    }
}
