package core.basesyntax.model;

import java.util.Arrays;

public class FruitTransaction {
    private Operation operation;
    private String fruit;
    private int quantity;

    public FruitTransaction(Operation operation, String fruit, int quantity) {
        this.operation = operation;
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

        private final String value;

        Operation(String code) {
            this.value = code;
        }

        public String getValue() {
            return value;
        }

        public static FruitTransaction.Operation getByValue(String value) {
            return Arrays.stream(Operation.values())
                    .filter(operation -> operation.getValue().equals(value))
                    .findFirst()
                    .orElseThrow(
                            () -> new IllegalArgumentException("Invalid value of Operation"
                                    + value));
        }
    }
}
