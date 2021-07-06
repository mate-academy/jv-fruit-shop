package core.basesyntax.dto;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;

public class Transaction {
    private final Operation operation;
    private final Fruit fruit;
    private final int quantity;

    public Transaction(Operation operation, Fruit fruit, int quantity) {
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
