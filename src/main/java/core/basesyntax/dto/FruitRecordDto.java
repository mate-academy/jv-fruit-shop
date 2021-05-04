package core.basesyntax.dto;

import core.basesyntax.service.OperationType;

public class FruitRecordDto {
    private OperationType operationType;
    private String fruitName;
    private int quantity;

    public FruitRecordDto(OperationType operation, String fruit, int quantity) {
        this.operationType = operation;
        this.fruitName = fruit;
        this.quantity = quantity;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public String getFruitName() {
        return fruitName;
    }

    public int getQuantity() {
        return quantity;
    }
}
