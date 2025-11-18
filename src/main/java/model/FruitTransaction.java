package model;

import java.util.Arrays;

public class FruitTransaction {
    private final Operation operation;
    private final String fruit;
    private final int quantity;

    public FruitTransaction(String code, String fruit, int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity can't be negative.");
        }
        this.operation = Operation.fromCode(code);
        this.fruit = fruit;
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

        private String getCode() {
            return code;
        }

        private static Operation fromCode(String code) {
            return Arrays.stream(values())
                    .filter(v -> v.getCode().equalsIgnoreCase(code))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("Invalid type of an operation: "
                            + code));
        }
    }
}
