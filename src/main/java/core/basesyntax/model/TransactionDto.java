package core.basesyntax.model;

public class TransactionDto {
    private OperationType operationType;
    private FruitType fruitType;
    private int fruitAmount;

    public TransactionDto(OperationType operationType, FruitType fruitType, int fruitAmount) {
        this.operationType = operationType;
        this.fruitType = fruitType;
        this.fruitAmount = fruitAmount;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public FruitType getFruitType() {
        return fruitType;
    }

    public int getFruitAmount() {
        return fruitAmount;
    }
}
