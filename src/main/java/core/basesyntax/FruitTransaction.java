package core.basesyntax;

public class FruitTransaction {
    private final String type;
    private final String fruit;
    private final int quantity;

    public FruitTransaction(String type, String fruit, int quantity) {
        this.type = type;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public String getType() {
        return type;
    }

    public String getFruit() {
        return fruit;
    }

    public int getQuantity() {
        return quantity;
    }
}

