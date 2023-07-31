package core.basesyntax.db;

public class FruitTransaction {
    private final String operation;
    private final String fruit;
    private final int quantity;

    FruitTransaction(String operation, String fruit, int quantity) {
        this.operation = operation;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public String getOperation() {
        return operation;
    }

    public String getFruit() {
        return fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "FruitTransaction{" +
                "operation='" + operation + '\'' +
                ", fruit='" + fruit + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
