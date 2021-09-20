package core.basesyntax.model;

import core.basesyntax.OperationType;

public class TransactionDto {
    private OperationType operationType;
    private Fruit fruit;
    private Integer fruitAmount;

    public TransactionDto(OperationType operationType, Fruit fruit, Integer fruitAmount) {
        this.operationType = operationType;
        this.fruit = fruit;
        this.fruitAmount = fruitAmount;
    }

    @Override
    public String toString() {
        return "operationType=" + operationType
                + ", fruitName=" + fruit.getFruitName()
                + ", fruitAmount=" + fruitAmount;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public void setOperationType(OperationType operationType) {
        this.operationType = operationType;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
    }

    public Integer getFruitAmount() {
        return fruitAmount;
    }

    public void setFruitAmount(Integer fruitAmount) {
        this.fruitAmount = fruitAmount;
    }
}
