package core.basesyntax.model;

public class FruitOperation {
    private String operation;
    private Fruit fruit;
    private int quantity;

    public FruitOperation(String operation, Fruit fruit, int quantity) {
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
