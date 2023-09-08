package model;

import strategy.OperationStrategy;

public class FruitTransaction implements Transaction {
    private Operation operation;
    private String fruit;
    private int quantity;

    public FruitTransaction(Operation operation, String fruit, int quantity) {
        this.operation = operation;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    @Override
    public OperationStrategy getOperationStrategy() {
        return operation.getOperationStrategy(this);
    }

    @Override
    public String getItemName() {
        return fruit;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

}
