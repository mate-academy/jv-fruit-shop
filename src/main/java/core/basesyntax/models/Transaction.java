package core.basesyntax.models;

public final class Transaction {
    private final String type;
    private final Fruit fruit;
    private final Integer quantity;

    public Transaction(String type, Fruit fruit, Integer quantity) {
        this.type = type;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public String getType() {
        return type;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
