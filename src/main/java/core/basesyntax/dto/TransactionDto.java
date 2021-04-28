package core.basesyntax.dto;

import core.basesyntax.model.Fruit;

public class TransactionDto {
    private final String operation;
    private final Fruit fruit;
    private final Integer amount;

    public TransactionDto(String operation, Fruit fruit, Integer amount) {
        this.operation = operation;
        this.fruit = fruit;
        this.amount = amount;
    }

    public String getOperation() {
        return operation;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public Integer getAmount() {
        return amount;
    }
}
