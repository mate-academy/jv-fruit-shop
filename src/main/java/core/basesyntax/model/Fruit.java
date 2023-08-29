package core.basesyntax.model;

public class Fruit {
    private String type;
    private String fruit;
    private int quantity;

    public Fruit(String type, String fruit, int quantity) {
        this.type = type;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public Fruit(String fruit, int quantity) {
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public Fruit() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    @Override
    public String toString() {
        return "FruitEntry{"
                + "type='" + type + '\''
                + ", fruit='" + fruit + '\''
                + ", quantity=" + quantity
                + '}';
    }
}
