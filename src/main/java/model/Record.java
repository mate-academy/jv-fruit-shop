package model;

public class Record {
    private String operationType;
    private String fruit;
    private int amount;

    public Record(String operationType, String fruit, int amount) {
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
