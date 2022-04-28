package core.basesyntax.model;

import core.basesyntax.service.Operation;

public class FruitTransaction {
    private Operation operation;
    private Fruit fruit;

    public FruitTransaction(Operation operation, Fruit fruit) {
        this.operation = operation;
        this.fruit = fruit;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
    }

    @Override
    public String toString() {
        return "FruitTransaction{"
                + "operation='" + operation + '\''
                + ", fruit=" + fruit
                + '}';
    }
}
