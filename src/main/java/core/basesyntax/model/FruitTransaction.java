package core.basesyntax.model;

import java.util.Objects;

public class FruitTransaction {
    private Operation operation;
    private String fruit;
    private Integer quantity;

    public FruitTransaction(Operation operation, String fruit, int quantity) {
        this.operation = operation;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public FruitTransaction() {

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

    @Override
    public boolean equals(Object fruitTransaction) {
        if (this == fruitTransaction) {
            return true;
        }
        if (fruitTransaction == null || getClass() != fruitTransaction.getClass()) {
            return false;
        }
        FruitTransaction that = (FruitTransaction) fruitTransaction;
        return Objects.equals(quantity, that.quantity) && operation == that.operation
                && Objects.equals(fruit, that.fruit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operation, fruit, quantity);
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %d", operation.toString(), fruit, quantity);
    }
}
