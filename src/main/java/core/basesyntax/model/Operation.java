package core.basesyntax.model;

public class Operation {
    private final OperationType operationType;
    private final String fruit;
    private final int count;

    public Operation(OperationType operationType, String fruit, int count) {
        this.operationType = operationType;
        this.fruit = fruit;
        this.count = count;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public String getFruit() {
        return fruit;
    }

    public int getCount() {
        return count;
    }
}
