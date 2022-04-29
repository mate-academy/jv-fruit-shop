package core.basesyntax.model;

public class FruitTransaction {
    private Fruit fruit;
    private String operation;
    private Integer quantity;

    public FruitTransaction(String operation, Fruit fruit, int quantity) {
        this.operation = operation;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public String getOperation() {
        return operation;
    }

    public int getQuantity() {
        return quantity;
    }
}

