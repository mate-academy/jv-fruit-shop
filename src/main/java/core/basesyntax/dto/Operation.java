package core.basesyntax.dto;

import java.util.Objects;

public class Operation {
    private OperationType operationType;
    private Fruit fruit;
    private int quantity;

    public Operation(OperationType operationType, Fruit fruit, int quantity) {
        this.operationType = operationType;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Operation)) {
            return false;
        }
        Operation operation = (Operation) o;
        return getQuantity() == operation.getQuantity()
                && getOperationType() == operation.getOperationType()
                && Objects.equals(getFruit(), operation.getFruit());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOperationType(), getFruit(), getQuantity());
    }

    public enum OperationType {
        UNKNOWN,
        BALANCE,
        SUPPLY,
        PURCHASE,
        RETURN
    }
}
