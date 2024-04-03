package core.basesyntax.database;

public class FruitActivity {
    private String operation;
    private String fruit;
    private int quantity;

    public FruitActivity(String operation, String fruit, int quantity) {
        this.operation = operation;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public String getOperation() {
        return operation;
    }

    public String getFruit() {
        return fruit;
    }

    public int getQuantity() {
        return quantity;
    }
}
