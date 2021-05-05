package core.basesyntax.model.dto;

import core.basesyntax.model.OperationType;

public class FruitRecordDto {
    private final OperationType operationType;
    private final String fruitType;
    private final int quantity;

    public FruitRecordDto(OperationType operationType, String fruitType, int quantity) {
        this.operationType = operationType;
        this.fruitType = fruitType;
        this.quantity = quantity;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public String getFruitType() {
        return fruitType;
    }

    public int getQuantity() {
        return quantity;
    }
}
