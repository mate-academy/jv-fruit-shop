package core.basesyntax.model;

import java.util.StringJoiner;

public class Record {
    private final Operation operation;
    private final String product;
    private final int quantity;

    public Record(Operation operation, String product, int quantity) {
        this.operation = operation;
        this.product = product;
        this.quantity = quantity;
    }

    public Operation getOperation() {
        return operation;
    }

    public String getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Record.class.getSimpleName() + "[", "]")
                .add("operation='" + operation + "'")
                .add("product='" + product + "'")
                .add("quantity=" + quantity)
                .toString();
    }
}
