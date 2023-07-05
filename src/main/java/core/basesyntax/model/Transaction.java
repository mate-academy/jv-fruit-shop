package core.basesyntax.model;

public class Transaction {
    private Operation operation;
    private String fruit;
    private Integer amount;

    public Transaction(Operation operation,
                       String fruit, int amount) {
        this.operation = operation;
        this.fruit = fruit;
        this.amount = amount;
    }

    public Operation getOperation() {
        return operation;
    }

    public String getFruit() {
        return fruit;
    }

    public int getAmount() {
        return amount;
    }
}
