package core.basesyntax.model;

public class FruitTransaction {
    private OperationType operationType;
    private String fruitName;
    private int amount;

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
