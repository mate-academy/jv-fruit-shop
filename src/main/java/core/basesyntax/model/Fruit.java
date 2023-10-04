package core.basesyntax.model;

public class Fruit {
    private String fruit;
    private int quantity;

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

    @Override
    public String toString() {
        return "Fruit{"
                + "fruit='" + fruit + '\''
                + ", quantity=" + quantity + '}';
    }
}
