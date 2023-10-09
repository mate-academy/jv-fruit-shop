package core.basesyntax.model;

import core.basesyntax.operation.Operation;

public class FruitTransaction {
    private Operation operation;
    private String name;
    private int amount;

    public FruitTransaction(Operation operation, String name, int amount) {
        this.operation = operation;
        this.name = name;
        this.amount = amount;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
