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
}
