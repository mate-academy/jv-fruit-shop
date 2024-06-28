package core.basesyntax.model;

import java.util.Arrays;

public class FruitTransaction {
    private final Operation operation;
    private final String fruit;
    private final int quantity;

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

        private final String operation;

        Operation(String code) {
            this.operation = code;
        }

        public String getOperation() {
            return operation;
        }

        public static FruitTransaction.Operation getOperationByValue(String operation) {
            return Arrays.stream(Operation.values())
                    .filter(it -> it.getOperation().equals(operation))
                    .findFirst()
                    .orElseThrow(
                            () -> new IllegalArgumentException(
                                    "Invalid value of Operation - " + operation));
        }
    }
}
