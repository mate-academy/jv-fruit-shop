package core.basesyntax.model;

import java.util.Arrays;

public class FruitTransaction {
    private String fruitName;
    private Operation operation;
    private int quantity;

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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

        public static Operation identifyOperation(String stringOperation) {
            return Arrays.stream(FruitTransaction.Operation.values())
                    .filter(e -> e.getOperation().equals(stringOperation))
                    .findFirst()
                    .get();
        }
    }
}
