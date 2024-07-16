package core.basesyntax.db;

public class FruitTransaction {
    private String fruit;
    private int quantity;
    private String type;

    public FruitTransaction(String fruit, int quantity) {
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public FruitTransaction(String type, String fruit, int quantity) {
        this.type = type;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public String getType() {
        return type;
    }

    public void setType() {
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
