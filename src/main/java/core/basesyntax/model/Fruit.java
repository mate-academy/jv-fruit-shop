package core.basesyntax.model;

public class Fruit {
    private final String nameFruit;
    private final int quantity;

    public Fruit(String nameFruit, int quantity) {
        this.nameFruit = nameFruit;
        this.quantity = quantity;
    }

    public String getNameFruit() {
        return nameFruit;
    }

    public int getQuantity() {
        return quantity;
    }
}
