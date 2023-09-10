package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import core.basesyntax.operations.Operation;

public class FruitTransaction {
    private Operation operationType;
    private Fruit fruit;

    public FruitTransaction(Operation operationType, Fruit fruit) {
        this.operationType = operationType;
        this.fruit = fruit;
    }

    public Operation getOperation() {
        return operationType;
    }

    public void setOperation(Operation operation) {
        this.operationType = operation;
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
                + "operationType=" + operationType
                + ", fruitName=" + fruit.getName()
                + ", quantity=" + fruit.getQuantity()
                + '}';
    }
}
