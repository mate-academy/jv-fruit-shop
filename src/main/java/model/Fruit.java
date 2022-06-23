package model;

public class Fruit {
    private final Operation operation;
    private final String fruit;
    private int quantity;

    public Fruit(Operation operation, String typeOfFruit, int quantityOfFruit) {
        this.operation = operation;
        this.fruit = typeOfFruit;
        this.quantity = quantityOfFruit;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getFruitType() {
        return fruit;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
