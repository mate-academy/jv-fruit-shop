package core.basesyntax.model;

public class FruitRecord {
    private String operation;
    private Fruit fruit;
    private int quantity;

    public FruitRecord(String operation, Fruit fruit, int quantity) {
        this.operation = operation;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public String getOperation() {
        return operation;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "FruitOperationdto{" + "operation='" + operation
                + '\'' + ", fruit=" + fruit.getName()
                + ", quantity=" + quantity + '}';
    }
}
