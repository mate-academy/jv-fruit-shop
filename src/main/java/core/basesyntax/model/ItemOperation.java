package core.basesyntax.model;

public class ItemOperation {
    private final Operation operation;
    private final String item;
    private final int quantity;

    public ItemOperation(Operation operation, String item, int quantity) {
        this.operation = operation;
        this.item = item;
        this.quantity = quantity;
    }

    public Operation getOperation() {
        return operation;
    }

    public String getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }
}
