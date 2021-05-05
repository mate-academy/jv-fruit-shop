package core.basesyntax.dto;

import java.util.Objects;

public class Operation {
    private final OperationType operationType;
    private final Fruit fruit;
    private final int quantity;

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
    public boolean equals(Object operation) {
        if (this == operation) {
            return true;
        }
        if (!(operation instanceof Operation)) {
            return false;
        }
        Operation newOperation = (Operation) operation;
        return getQuantity() == newOperation.getQuantity()
                && getOperationType() == newOperation.getOperationType()
                && Objects.equals(getFruit(), newOperation.getFruit());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOperationType(), getFruit(), getQuantity());
    }

    public enum OperationType {
        BALANCE,
        SUPPLY,
        PURCHASE,
        RETURN
    }
}
