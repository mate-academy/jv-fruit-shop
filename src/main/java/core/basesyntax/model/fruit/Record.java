package core.basesyntax.model.fruit;

public class Record {
    private final Operation operation;
    private final String fruit;
    private final int quantity;

    public Record(Operation operation, String fruit, int quantity) {
        this.operation = operation;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public Operation getOperation() {
        return operation;
    }

    public String getFruit() {
        return fruit;
    }

    public int getQuantity() {
        return quantity;
    }
}
