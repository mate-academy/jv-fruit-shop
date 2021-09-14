package core.basesyntax.model;

public class FruitRecord {
    private final Operation operation;
    private final Fruit fruit;
    private final int amount;

    public FruitRecord(Operation operation, Fruit fruit, int amount) {
        this.operation = operation;
        this.fruit = fruit;
        this.amount = amount;
    }

    public Operation getOperation() {
        return operation;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "FruitRecord{"
                + "operation=" + operation
                + ", Fruit='" + fruit + '\''
                + ", amount=" + amount
                + '}';
    }

    public enum Operation {
        BALANCE,
        SUPPLY,
        PURCHASE,
        RETURN;
    }
}
