package core.basesyntax.model;

public class Transaction {
    private final TransactionType type;
    private final String fruitName;
    private final int value;

    public Transaction(TransactionType type, String fruitName, int value) {
        this.type = type;
        this.fruitName = fruitName;
        this.value = value;
    }

    public TransactionType getType() {
        return type;
    }

    public String getFruitName() {
        return fruitName;
    }

    public int getValue() {
        return value;
    }
}
