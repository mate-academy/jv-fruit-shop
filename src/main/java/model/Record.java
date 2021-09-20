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

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public String getFruit() {
        return fruit;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Record{" +
                "operationType='" + operationType + '\'' +
                ", fruit='" + fruit + '\'' +
                ", amount=" + amount +
                '}';
    }
}
