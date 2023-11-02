package core.basesyntax.model;

import java.util.Objects;

public class FruitTransaction {
    private OperationsWithFruits operation;
    private String fruitName;
    private int quantity;

    public FruitTransaction() {

    }

    public FruitTransaction(OperationsWithFruits operation, String fruitName, int quantity) {
        this.quantity = quantity;
        this.fruitName = fruitName;
        this.operation = operation;
    }

    public OperationsWithFruits getOperation() {
        return operation;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setOperation(OperationsWithFruits operation) {
        this.operation = operation;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof FruitTransaction that)) {
            return false;
        }

        return quantity == that.quantity
                && Objects.equals(operation, that.operation)
                && Objects.equals(fruitName, that.fruitName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operation, fruitName, quantity);
    }
}
