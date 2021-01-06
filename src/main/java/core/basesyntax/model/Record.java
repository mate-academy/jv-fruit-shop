package core.basesyntax.model;

import java.util.Objects;

public class Record {
    private Operation operation;
    private Fruit fruit;
    private long amount;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Record)) {
            return false;
        }
        Record record = (Record) o;
        return amount == record.amount
                && operation == record.operation
                && Objects.equals(fruit, record.fruit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operation, fruit, amount);
    }
}
