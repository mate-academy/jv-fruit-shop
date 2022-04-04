package core.basesyntax.model;

public class FruitTransaction {
    private String operation;
    private Fruit fruit;
    private int quantity;

    public FruitTransaction(String operation, Fruit fruit, int quantity) {
        this.operation = operation;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public String getOperation() {
        return operation;
    }

    public int getQuantity() {
        return quantity;
    }

    public Fruit getFruit() {
        return fruit;
    }
}
