package core.basesyntax.dto;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;

public class TransactionDto {
    private final Operation operation;
    private final Fruit fruit;
    private final Integer amount;

    public TransactionDto(Operation operation, Fruit fruit, Integer amount) {
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

    public Integer getAmount() {
        return amount;
    }
}
