package core.basesyntax.model;

public final class FruitTransaction {
    private final Operation operation;
    private final Fruit fruit;
    private final int quantity;

    public FruitTransaction(final Operation operation,
                            final Fruit fruit,
                            final int quantity) {
        this.operation = operation;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public Operation getOperation() {
        return operation;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public int getQuantity() {
        return quantity;
    }
}
