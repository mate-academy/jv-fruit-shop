package core.basesyntax.dao.transaction;

import core.basesyntax.dao.operation.Operation;

public class FruitTransaction {
    private Operation operation;
    private String name;
    private Integer quantity;

    public FruitTransaction(Operation operation, String name, Integer quantity) {
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

    public Integer getQuantity() {
        return quantity;
    }
}
