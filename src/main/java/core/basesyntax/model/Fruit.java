package core.basesyntax.model;

public class Fruit {
    private int quantity;
    private String fruit;

    public Fruit(int quantity, String fruit) {
        this.quantity = quantity;
        this.fruit = fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getFruit() {
        return fruit;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }
}
