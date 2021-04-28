package model;

import service.Activity;

public class FruitRecordDto {
    private Activity operationType;
    private String fruitType;
    private int amount;

    public FruitRecordDto(Activity operationType, String fruitType, int amount) {
        this.operationType = operationType;
        this.fruitType = fruitType;
        this.amount = amount;
    }

    public Activity getOperationType() {
        return operationType;
    }

    public String getFruitType() {
        return fruitType;
    }

    public int getAmount() {
        return amount;
    }
}
