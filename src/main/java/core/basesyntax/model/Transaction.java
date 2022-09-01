package core.basesyntax.model;

public class Transaction {
    private Fruit fruit;
    private int quantity;
    private String operation;

    public Transaction(Fruit fruit, int quantity, String operation) {
        this.fruit = fruit;
        this.quantity = quantity;
        this.operation = operation;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getOperation() {
        return operation;
    }

    @Override
    public String toString() {
        return "Transaction{"
                + "fruit=" + fruit + ", quantity=" + quantity
                + ", operation='" + operation
                + '\'' + '}';
    }
}
