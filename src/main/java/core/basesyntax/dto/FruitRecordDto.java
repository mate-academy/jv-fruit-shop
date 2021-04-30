package core.basesyntax.dto;

import core.basesyntax.model.Operation;

public class FruitRecordDto {
    private Operation operationType;
    private String fruitName;
    private Integer quantity;

    public FruitRecordDto(Operation operationType, String fruitName, Integer quantity) {
        this.operationType = operationType;
        this.fruitName = fruitName;
        this.quantity = quantity;
    }

    public Operation getOperationType() {
        return operationType;
    }

    public String getFruitName() {
        return fruitName;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
