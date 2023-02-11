package core.basesyntax.strategy.transactions;

import core.basesyntax.strategy.Operation;

public class FruitTransaction {
    private Operation operation;
    private String fruitName;
    private Integer valueOfFruit;

    public FruitTransaction() {
    }

    public Operation getOperation() {
        return operation;
    }

    public String getFruitName() {
        return fruitName;
    }

    public Integer getValueOfFruit() {
        return valueOfFruit;
    }

    public FruitTransaction setOperation(Operation operation) {
        this.operation = operation;
        return this;
    }

    public FruitTransaction setFruitName(String fruitName) {
        this.fruitName = fruitName;
        return this;
    }

    public FruitTransaction setValueOfFruit(Integer valueOfFruit) {
        this.valueOfFruit = valueOfFruit;
        return this;
    }
}
