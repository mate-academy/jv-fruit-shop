package core.basesyntax.model;

public class TransactionDto {
    private final String operation;
    private final Fruit fruit;
    private final int quantity;

    public TransactionDto(String operation, Fruit fruit, int quantity) {
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
}
