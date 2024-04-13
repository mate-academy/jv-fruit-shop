package core.basesyntax.model;

public class Fruit {
    private String fruit;
    private int quantity;

    public Fruit(String name, int quantity) {
        this.fruit = name;
        this.quantity = quantity;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getFruit() {
        return fruit;
    }
}
