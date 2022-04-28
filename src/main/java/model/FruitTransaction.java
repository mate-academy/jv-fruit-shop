package model;

public class FruitTransaction {
    private Fruit fruit;
    private int quantity;
    private String operation;

    public FruitTransaction(Fruit fruit, int quantity, String operation) {
        this.fruit = fruit;
        this.quantity = quantity;
        this.operation = operation;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getOperation() {
        return operation;
    }
}
