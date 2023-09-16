package core.basesyntax.model;

public class FruitTransaction {
    private final OperationType operationType;
    private final String fruitName;
    private final int amount;

    public FruitTransaction(OperationType operationType, String name, int amount) {
        this.operationType = operationType;
        this.fruitName = name;
        this.amount = amount;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public String getFruitName() {
        return fruitName;
    }

    public int getAmount() {
        return amount;
    }
}
