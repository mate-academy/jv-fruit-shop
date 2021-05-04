package core.basesyntax.model.dto;

public class FruitRecordDto {
    private final String operationType;
    private final String fruitType;
    private final int quantity;

    public FruitRecordDto(String operationType, String fruitType, int quantity) {
        this.operationType = operationType;
        this.fruitType = fruitType;
        this.quantity = quantity;
    }

    public String getOperationType() {
        return operationType;
    }

    public String getFruitType() {
        return fruitType;
    }

    public int getQuantity() {
        return quantity;
    }
}
