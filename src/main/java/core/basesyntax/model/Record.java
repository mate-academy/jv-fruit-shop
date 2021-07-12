package core.basesyntax.model;

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
}
