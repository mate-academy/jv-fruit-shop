package core.basesyntax.model;

import core.basesyntax.strategy.Operation;

public class Transaction {
    private Operation operation;
    private Fruit fruit;
    private int quantity;

    public Transaction(Operation operation, Fruit fruit, int quantity) {
        this.operation = operation;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public Operation getOperation() {
        return operation;
    }

    public Transaction setOperation(Operation operation) {
        this.operation = operation;
        return this;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public Transaction setFruit(Fruit fruit) {
        this.fruit = fruit;
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public Transaction setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "operation=" + operation +
                ", fruit=" + fruit +
                ", quantity=" + quantity +
                '}';
    }
}
