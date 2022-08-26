package core.basesyntax.model;

public class Fruit {
    private String fruitName;
    private int quantity;

    public Fruit(String name, int quantity) {
        this.fruitName = name;
        this.quantity = quantity;
    }

    public Fruit() {
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
