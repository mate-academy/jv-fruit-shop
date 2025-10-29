package core.basesyntax.model;

import core.basesyntax.db.Operation;

public class FruitTransaction {

    private final Operation operation;
    private final String product;
    private final int quantity;

    public FruitTransaction(Operation operation, String product, int quantity) {
        this.operation = operation;
        this.product = product;
        this.quantity = quantity;
    }

    public String getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public Operation getOperation() {
        return operation;
    }
}
