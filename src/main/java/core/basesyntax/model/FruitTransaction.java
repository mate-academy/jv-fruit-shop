package core.basesyntax.model;

public class FruitTransaction {
    private Operation operation;
    private Fruit fruit;
    private int amount;

    public FruitTransaction(Operation operation, Fruit fruit, int amount) {
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
}
