package core.basesyntax.model;

import java.util.Objects;

public class Record {
    public enum OperationType {
        BALANCE, SUPPLY, PURCHASE, RETURN
    }

    private final OperationType operation;
    private final String fruitName;
    private final int quantity;

    public Record(OperationType operation, String fruitName, int quantity) {
        this.operation = operation;
        this.fruitName = fruitName;
        this.quantity = quantity;
    }

    public OperationType getOperation() {
        return operation;
    }

    public String getFruitName() {
        return fruitName;
    }

    public int getQuantity() {
        return quantity;
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
        return quantity == record.quantity && operation == record.operation
                && Objects.equals(fruitName, record.fruitName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operation, fruitName, quantity);
    }
}
