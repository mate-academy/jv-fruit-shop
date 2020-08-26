package core.basesyntax.order;

public class Order {
    private String type;
    private String fruit;
    private int quantity;

    public Order(String type, String fruit, int quantity) {
        this.type = type;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Order{" +
                "type='" + type + '\'' +
                ", fruit='" + fruit + '\'' +
                ", quantity=" + quantity +
                '}';
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
}
