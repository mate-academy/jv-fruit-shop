package service.impl;

import model.Fruit;

public class TransactionDto {
    private final Fruit fruit;
    private final int amount;
    private final String operationType;

    public TransactionDto(String operationType, Fruit fruit, int amount) {
        this.fruit = fruit;
        this.amount = amount;
        this.operationType = operationType;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public int getAmount() {
        return amount;
    }

    public String getOperationType() {
        return operationType;
    }
}
