package core.basesyntax.model;

import java.util.Objects;

public class FruitTransaction {
    private Operation operation;
    private String fruitName;
    private int quantity;

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        FruitTransaction that = (FruitTransaction) obj;
        return quantity == that.quantity
                && operation == that.operation
                && Objects.equals(fruitName, that.fruitName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operation, fruitName, quantity);
    }

    @Override
    public String toString() {
        return "FruitTransaction: operation: " + operation
                + ", fruitName: " + fruitName + ", quantity: " + quantity + ".\n";
    }

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private final String type;

        Operation(String type) {
            this.type = type;
        }

        public static Operation getType(String type) {
            for (Operation operation: Operation.values()) {
                if (operation.type.equals(type)) {
                    return operation;
                }
            }
            throw new RuntimeException("There is no such operation type: " + type);
        }
    }
}
