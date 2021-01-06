package core.basesyntax.service;

import core.basesyntax.model.Operation;

public class Validator {
    public static void validate(String[] parsed) {
        String operation = parsed[0];
        String item = parsed[1];
        int quantity = Integer.parseInt(parsed[2]);
        if ("".equals(operation) || "".equals(item)) {
            throw new RuntimeException("Invalid line in file");
        }
        if (quantity < 0) {
            throw new RuntimeException("Negative quantity!");
        }
        Operation.fromString(operation);
    }

    public static void validate(int quantity) {
        if (quantity < 0) {
            throw new RuntimeException("Negative quantity!");
        }
    }
}
