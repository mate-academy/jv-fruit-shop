package model;

public class FruitRecordDto {
    private String operationType;
    private String fruitType;
    private int amount;

    public FruitRecordDto(String operationType, String fruitType, int amount) {
        this.operationType = operationType;
        this.fruitType = fruitType;
        this.amount = amount;
    }

    public String getFruitType() {
        return fruitType;
    }

    public int getAmount() {
        return amount;
    }

    public String getOperationType() {
        return operationType;
    }
}
