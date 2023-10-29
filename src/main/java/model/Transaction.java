package model;

public class Transaction {
    private int value;
    private String fruit;
    private Operation operation;

    public int getFruitValue() {
        return value;
    }

    public String getFruitName() {
        return fruit;
    }

    public Operation getFruitOperationType() {
        return operation;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    public void setFruitOperation(Operation operation) {
        this.operation = operation;
    }
}
