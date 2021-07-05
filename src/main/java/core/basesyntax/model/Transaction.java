package core.basesyntax.model;

public class Transaction {
    private final Operation operation;
    private final Fruit fruit;
    private int quantity;

    public Transaction(Operation operation, Fruit fruit, int quantity) {
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

    @Override
    public String toString() {
        return "Transaction{"
                + "operation=" + operation
                + ", fruit=" + fruit
                + ", quantity=" + quantity
                + '}';
    }
}
