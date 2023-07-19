package model;

public class Fruit {
    private String fruitName;
    private int quantity;

    public Fruit(String fuitName, int quantity) {
        this.fruitName = fuitName;
        this.quantity = quantity;
    }

    public String getFuitName() {
        return fruitName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setFuitName(String fuitName) {
        this.fruitName = fuitName;
    }

}
