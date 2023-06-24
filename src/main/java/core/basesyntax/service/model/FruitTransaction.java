package core.basesyntax.service.model;

public class FruitTransaction {
    private final String operation;
    private final String fruit;
    private final int value;

    public FruitTransaction(String operation, String fruit, int value) {
        this.operation = operation;
        this.fruit = fruit;
        this.value = value;
    }

    public String getOperation() {
        return operation;
    }

    public String getFruit() {
        return fruit;
    }

    public int getValue() {
        return value;
    }
}
