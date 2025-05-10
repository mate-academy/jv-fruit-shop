package core.basesyntax.service;

public class FruitStorage {
    private String fruit;
    private int quantity;

    public FruitStorage(String fruit, int quantity) {
        this.fruit = fruit;
        this.quantity = quantity;
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

    public void addFruit(int quantityAdd) {
        this.quantity += quantityAdd;
    }

    public void subtractFruit(int quantityAdd) {
        this.quantity -= quantityAdd;
    }
}
