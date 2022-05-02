package model;

public class Transaction {
    private String operation;
    private Fruit fruit;
    private int quantity;

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
