package core.basesyntax.model;

public class Record {
    Operation operation;
    Fruit fruit;
    long amount;

    public Record(Operation operation, Fruit fruit, long amount) {
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

    public long getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return operation.getOperation()
                + "," + fruit.type
                + "," + amount;
    }
}
