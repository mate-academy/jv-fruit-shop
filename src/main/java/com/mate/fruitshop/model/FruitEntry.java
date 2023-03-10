package com.mate.fruitshop.model;

public class FruitEntry {
    private final String fruitName;
    private int quantity;

    public FruitEntry(String fruitName, int quantity) {
        this.fruitName = fruitName;
        this.quantity = quantity;
    }

    public String getFruitName() {
        return fruitName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
