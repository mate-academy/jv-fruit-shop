package model;

import strategy.OperationHandler;

public class Fruit {
    private final OperationHandler operation;
    private final String fruit;
    private int quantity;

    public Fruit(OperationHandler operation, String typeOfFruit, int quantityOfFruit) {
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

    public OperationHandler getOperation() {
        return operation;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
