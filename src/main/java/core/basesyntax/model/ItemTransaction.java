package core.basesyntax.model;

import java.util.Objects;

public final class ItemTransaction {
    private final Operation operation;
    private final String name;
    private final int quantity;

    public ItemTransaction(Operation operation, String item, int quantity) {
        this.operation = operation;
        this.name = item;
        this.quantity = quantity;
    }

    public Operation getOperation() {
        return operation;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ItemTransaction that = (ItemTransaction) o;
        return quantity == that.quantity
                && operation == that.operation
                && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operation, name, quantity);
    }
}
