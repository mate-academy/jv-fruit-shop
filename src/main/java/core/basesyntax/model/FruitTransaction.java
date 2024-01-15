package core.basesyntax.model;

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

    public Fruit getFruit() {
        return fruit;
    }

    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

}
