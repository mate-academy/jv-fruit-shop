package core.basesyntax.model;

public class TransactionDto {
    private OperationType operationType;
    private Fruit fruit;
    private int fruitAmount;

    public TransactionDto(OperationType operationType, Fruit fruit, int fruitAmount) {
        this.operationType = operationType;
        this.fruit = fruit;
        this.fruitAmount = fruitAmount;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public Fruit getFruitType() {
        return fruit;
    }

    public int getFruitAmount() {
        return fruitAmount;
    }
}
