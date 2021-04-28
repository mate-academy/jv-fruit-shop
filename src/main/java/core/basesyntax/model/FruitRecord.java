package core.basesyntax.model;

public class FruitRecord {
    private final Fruit fruit;
    private final OperationType operationType;

    public FruitRecord(Fruit fruit, OperationType operationType) {
        this.fruit = fruit;
        this.operationType = operationType;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    @Override
    public String toString() {
        return "FruitRecord{" +
                "fruit=" + fruit.toString() +
                ", operationType=" + operationType +
                '}';
    }
}
