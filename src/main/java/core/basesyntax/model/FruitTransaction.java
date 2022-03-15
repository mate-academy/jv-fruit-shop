package core.basesyntax.model;

public class FruitTransaction {
    private final OperationType operationType;
    private final Fruit fruit;

    public FruitTransaction(OperationType operationType, Fruit fruit) {
        this.operationType = operationType;
        this.fruit = fruit;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public Fruit getFruit() {
        return fruit;
    }
}
