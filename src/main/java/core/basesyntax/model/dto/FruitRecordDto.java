package core.basesyntax.model.dto;

import core.basesyntax.service.impl.OperationType;

public class FruitRecordDto {
    private String fruitName;
    private OperationType operationType;
    private int quantity;

    public FruitRecordDto(OperationType operationType, String fruitName, int quantity) {
        this.operationType = operationType;
        this.fruitName = fruitName;
        this.quantity = quantity;
    }

    public String getFruitName() {
        return fruitName;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public int getQuantity() {
        return quantity;
    }
}
