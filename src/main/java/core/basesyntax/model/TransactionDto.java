package core.basesyntax.model;

import java.util.Objects;

public class TransactionDto {
    private final Operation operation;
    private final Fruit fruit;
    private final Integer quantity;

    public TransactionDto(Operation operation, Fruit fruit, Integer quantity) {
        this.operation = operation;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public Operation getOperation() {
        return operation;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public Integer getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object transaction) {
        if (this == transaction) {
            return true;
        }
        if (transaction == null) {
            return false;
        }
        if (getClass().equals(transaction.getClass())) {
            TransactionDto that = (TransactionDto) transaction;
            return operation == that.operation && Objects.equals(fruit, that.fruit)
                    && Objects.equals(quantity, that.quantity);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(operation, fruit, quantity);
    }
}
