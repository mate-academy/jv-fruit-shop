package core.basesyntax.model;

import java.util.Objects;

public class TransactionDto {
    private Operation operation;
    private Fruit fruit;
    private Integer quantity;

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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TransactionDto that = (TransactionDto) o;
        return operation == that.operation
                && Objects.equals(fruit, that.fruit)
                && Objects.equals(quantity, that.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operation, fruit, quantity);
    }

    @Override
    public String toString() {
        return "TransactionDto{"
                + "operation=" + operation
                + ", fruit=" + fruit
                + ", quantity="
                + +'}';
    }
}
