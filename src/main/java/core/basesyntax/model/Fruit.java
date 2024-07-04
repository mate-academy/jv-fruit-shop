package core.basesyntax.model;

public class Fruit {
    private String fruit;
    private int quantity;

    public Fruit(String fruit, int quantity) {
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public String getFruit() {
        return fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Fruit{"
                + "fruit='" + fruit + '\''
                + ", quantity=" + quantity
                + '}';
    }
}
