package model;

public class OperationUnit {
    private final String fruit;
    private final Integer operationAmount;
    private final Integer storedAmount;

    public OperationUnit(String fruit, Integer operationAmount, Integer storedAmount) {
        this.fruit = fruit;
        this.operationAmount = operationAmount;
        this.storedAmount = storedAmount;
    }

    public String getFruit() {
        return fruit;
    }

    public Integer getOperationAmount() {
        return operationAmount;
    }

    public Integer getStoredAmount() {
        return storedAmount;
    }
}
