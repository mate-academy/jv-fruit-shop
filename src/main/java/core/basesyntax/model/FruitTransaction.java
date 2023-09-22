package core.basesyntax.model;

public class FruitTransaction {
    private Operation transaction;
    private String fruitName;
    private int amount;

    public FruitTransaction(Operation operation, String fruitName, int amount) {
        this.transaction = operation;
        this.fruitName = fruitName;
        this.amount = amount;
    }

    public Operation getTransaction() {
        return transaction;
    }

    public String getFruitName() {
        return fruitName;
    }

    public int getAmount() {
        return amount;
    }
}
