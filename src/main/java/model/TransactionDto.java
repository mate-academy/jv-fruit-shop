package model;

public class TransactionDto {
    private final String operationType;
    private final String fruit;
    private final int amount;

    public TransactionDto(String operationType, String fruit, int amount) {
        this.operationType = operationType;
        this.fruit = fruit;
        this.amount = amount;
    }

    public String getOperationType() {
        return operationType;
    }

    public String getFruit() {
        return fruit;
    }

    public int getAmount() {
        return amount;
    }
}
