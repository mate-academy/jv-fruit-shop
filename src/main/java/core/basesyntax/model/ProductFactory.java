package core.basesyntax.model;

import java.util.Objects;

public class ProductFactory {
    private Operation operation;
    private Fruit fruit;
    private int amount;

    public ProductFactory(Operation operation, Fruit fruit, int amount) {
        this.operation = operation;
        this.fruit = fruit;
        this.amount = amount;
    }

    public Operation getOperation() {
        return operation;
    }

    public Fruit getFruit() {
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
        ProductFactory that = (ProductFactory) entity;
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
