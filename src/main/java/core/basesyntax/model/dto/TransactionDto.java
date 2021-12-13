package core.basesyntax.model.dto;

import core.basesyntax.model.operations.Operation;
import core.basesyntax.model.product.Fruit;

public class TransactionDto {
    private final Operation operation;
    private final Fruit fruit;
    private final int amount;

    public TransactionDto(Operation operation, Fruit fruit, int amount) {
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
}
