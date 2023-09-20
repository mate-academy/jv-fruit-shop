package core.basesyntax.model;

public class FruitTransaction {
    private Transaction transaction;
    private String fruitName;
    private int amount;

    public FruitTransaction(Transaction transaction, String fruitName, int amount) {
        this.transaction = transaction;
        this.fruitName = fruitName;
        this.amount = amount;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public String getFruitName() {
        return fruitName;
    }

    public int getAmount() {
        return amount;
    }
}
