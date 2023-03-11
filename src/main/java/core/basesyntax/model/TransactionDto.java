package core.basesyntax.model;

public class TransactionDto {
    private String operation;
    private String fruit;
    private int amount;

    public TransactionDto(String operation, String fruit, int amount) {
        this.operation = operation;
        this.fruit = fruit;
        this.amount = amount;
    }

    public String getOperation() {
        return operation;
    }

    public String getFruit() {
        return fruit;
    }

    public int getAmount() {
        return amount;
    }
}
