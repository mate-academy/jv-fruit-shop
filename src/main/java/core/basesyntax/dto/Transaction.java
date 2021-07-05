package core.basesyntax.dto;

import core.basesyntax.fruit.Fruit;

public class Transaction {
    private final Operations operation;
    private final Fruit fruit;
    private int quantity;

    public Transaction(Operations operation, Fruit fruit, int quantity) {
        this.operation = operation;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public Operations getOperation() {
        return operation;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Transaction{"
                + "operation=" + operation
                + ", fruit=" + fruit
                + ", quantity=" + quantity
                + '}';
    }
}
