package core.basesyntax.model;

public class Fruit {
    private String fruit;
    private int quantity;

    public Fruit(String fruit, int amount) {
        this.fruit = fruit;
        this.quantity = amount;
    }

    public String getFruit() {
        return fruit;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
