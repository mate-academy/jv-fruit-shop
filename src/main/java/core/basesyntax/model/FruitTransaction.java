package core.basesyntax.model;

import java.util.Objects;

public class FruitTransaction {
    private final Operation operation;
    private final String fruit;
    private final int quantity;

    public FruitTransaction(Operation operation, String fruit, int quantity) {
        this.operation = Objects.requireNonNull(operation);
        this.fruit = Objects.requireNonNull(fruit).trim();
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity must be non-negative");
        }
        this.quantity = quantity;
    }

    public Operation getOperation() {
        return operation;
    }

    public String getFruit() {
        return fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private final String code;

        Operation(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }

        public static Operation fromCode(String code) {
            if (code == null) {
                throw new IllegalArgumentException("Operation code is null");
            }
            switch (code.trim().toLowerCase()) {
                case "b":
                    return BALANCE;
                case "s":
                    return SUPPLY;
                case "p":
                    return PURCHASE;
                case "r":
                    return RETURN;
                default:
                    throw new IllegalArgumentException("Unknown operation code: " + code);
            }
        }
    }
}
