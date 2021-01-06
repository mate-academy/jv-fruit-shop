package core.basesyntax.model;

public class Transaction {
    private Integer amount;
    private Fruit fruitName;
    private Operations operation;

    public Transaction(Operations operation, Fruit fruitName, Integer amount) {
        this.operation = operation;
        this.fruitName = fruitName;
        this.amount = amount;
    }

    public Integer getAmount() {
        return amount;
    }

    public Fruit getFruitName() {
        return fruitName;
    }

    public Operations getOperation() {
        return operation;
    }
}
