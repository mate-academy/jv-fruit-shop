package core.basesyntax.model;

public class Transaction {
    private Integer amount;
    private Fruits fruitName;
    private Operations operation;

    public Transaction(Operations operation, Fruits fruitName, Integer amount) {
        this.operation = operation;
        this.fruitName = fruitName;
        this.amount = amount;
    }

    public Integer getAmount() {
        return amount;
    }

    public Fruits getFruitName() {
        return fruitName;
    }

    public Operations getOperation() {
        return operation;
    }
}
