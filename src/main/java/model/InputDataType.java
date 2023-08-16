package model;

public class InputDataType {
    private final Operation operation;
    private final Fruit fruit;

    public InputDataType(Operation operation, Fruit fruit) {
        this.operation = operation;
        this.fruit = fruit;
    }

    public Operation getOperation() {
        return operation;
    }

    public Fruit getFruit() {
        return fruit;
    }
}
