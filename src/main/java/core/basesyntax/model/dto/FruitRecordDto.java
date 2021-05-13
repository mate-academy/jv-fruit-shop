package core.basesyntax.model.dto;

import core.basesyntax.service.impl.Operation;

public class FruitRecordDto {
    private Operation operationType;
    private String fruitName;
    private Integer quantity;

    public FruitRecordDto(Operation operationType, String fruitName, Integer quantity) {
        this.operationType = operationType;
        this.fruitName = fruitName;
        this.quantity = quantity;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Operation getOperationType() {
        return operationType;
    }

    public String getFruitName() {
        return fruitName;
    }
}
