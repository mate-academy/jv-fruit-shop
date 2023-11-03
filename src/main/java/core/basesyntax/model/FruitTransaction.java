package core.basesyntax.model;

import java.util.Objects;

public class FruitTransaction {
    private Operation operation;
    private int quantity;
    private String fruitName;

    public FruitTransaction() {

    }

    public FruitTransaction(Operation operation, String fruitName, int quantity) {
        this.fruitName = fruitName;
        this.quantity = quantity;
        this.operation = operation;
    }

    public Operation getOperation() {
        return operation;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setOperation(Operation operation) {
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
