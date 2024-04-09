package model;

public class FruitTransaction {
    private Operation operation;
    private String fruit;
    private String quantity;

    public FruitTransaction(Operation operation, String fruit, String quantity) {
        this.operation = operation;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getFruit() {
        return fruit;
    }

    public Operation getOperation() {
        return operation;
    }
}
