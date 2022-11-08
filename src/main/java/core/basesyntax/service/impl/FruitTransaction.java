package core.basesyntax.service.impl;

public class FruitTransaction {
    private String operation;
    private int quantity;
    private String fruit;

    public FruitTransaction(String operation, int quantity, String fruit) {
        this.operation = operation;
        this.quantity = quantity;
        this.fruit = fruit;
    }

    public String getOperation() {
        return operation;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getFruit() {
        return fruit;
    }
}
