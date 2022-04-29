package core.basesyntax.models;

public final class Transaction {
    private final String type;
    private final String name;
    private final Integer quantity;

    public Transaction(String type, String name, Integer quantity) {
        this.type = type;
        this.name = name;
        this.quantity = quantity;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
