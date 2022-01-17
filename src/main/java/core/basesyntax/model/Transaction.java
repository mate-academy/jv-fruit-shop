package core.basesyntax.model;

public class Transaction {
    private final TransactionType type;
    private final String fruitName;
    private final int amount;

    public Transaction(TransactionType type, String fruitName, int amount) {
        this.type = type;
        this.fruitName = fruitName;
        this.amount = amount;
    }

    public TransactionType getType() {
        return type;
    }

    public String getFruitName() {
        return fruitName;
    }

    public int getAmount() {
        return amount;
    }
}
