package core.basesyntax.dto;

import core.basesyntax.model.Operation;

public class Transaction {
    private Operation operation;
    private String name;
    private int quantity;

    public Transaction(Operation operation, String name, int quantity) {
        this.operation = operation;
        this.name = name;
        this.quantity = quantity;
    }

    public Operation getOperation() {
        return operation;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }
}
