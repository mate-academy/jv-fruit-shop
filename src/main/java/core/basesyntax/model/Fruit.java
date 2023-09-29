package core.basesyntax.model;

public class Fruit {
    private String fruit;
    private int quantity;

    public Fruit(String fruitName, int quantity) {
        this.fruit = fruitName;
        this.quantity = quantity;
    }

    public String getFruitName() {
        return fruit;
    }

    public int getQuantity() {
        return quantity;
    }
}
