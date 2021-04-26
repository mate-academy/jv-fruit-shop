package core.basesyntax.model;

import java.util.Objects;

public class Transaction {
    private Operation operation;
    private Product fruit;
    private int amount;

    public Transaction(Operation operation, Product fruit, int amount) {
        this.operation = operation;
        this.fruit = fruit;
        this.amount = amount;
    }

    public Operation getOperation() {
        return operation;
    }

    public Product getFruit() {
        return fruit;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object entity) {
        if (this == entity) {
            return true;
        }
        if (entity == null || getClass() != entity.getClass()) {
            return false;
        }
        Transaction that = (Transaction) entity;
        return amount == that.amount
                && operation == that.operation
                && Objects.equals(fruit, that.fruit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operation, fruit, amount);
    }

    @Override
    public String toString() {
        return "ProductFactory{" + "operation=" + operation
                + ", fruit=" + fruit
                + ", amount=" + amount + '}';
    }
}
