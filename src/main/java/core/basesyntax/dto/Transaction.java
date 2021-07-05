package core.basesyntax.dto;

import core.basesyntax.model.OperationType;

public class Transaction {
    private OperationType operationType;
    private String name;
    private int quantity;

    public Transaction(OperationType operationType, String name, int quantity) {
        this.operationType = operationType;
        this.name = name;
        this.quantity = quantity;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }
}
