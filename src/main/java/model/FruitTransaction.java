package model;

public class FruitTransaction {
    private Operation operationType;
    private Fruit fruit;
    private int quantity;

    public FruitTransaction(String operationType, Fruit fruit, int quantity) {
        this.operationType = Operation.getByValue(operationType);
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public Operation getOperationType() {
        return operationType;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public int getQuantity() {
        return quantity;
    }
}
