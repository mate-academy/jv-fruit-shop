package core.basesyntax.model;

import java.util.Arrays;

public class FruitTransaction {
    private static final String INVALID_OPERATION = "Invalid value of Operation ";
    private final Operation operation;
    private final String fruitName;
    private final int quantity;

    public FruitTransaction(Operation operation, String fruitName, int quantity) {
        this.operation = operation;
        this.fruitName = fruitName;
        this.quantity = quantity;
    }

    public Operation getOperation() {
        return operation;
    }

    public String getFruitName() {
        return fruitName;
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

        Operation(String operation) {
            this.operation = operation;
        }

        public String getOperation() {
            return operation;
        }

        public static FruitTransaction.Operation getOperationByValue(String operation) {
            return Arrays.stream(Operation.values())
                    .filter(o -> o.getOperation().equals(operation))
                    .findFirst().orElseThrow(
                            () -> new IllegalArgumentException(INVALID_OPERATION + operation));
        }
    }
}
