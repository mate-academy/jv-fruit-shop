package core.basesyntax.dto;

import core.basesyntax.service.OperationType;

public class FruitRecordDto {
    private OperationType operationType;
    private String fruitName;
    private Integer quantity;

    public FruitRecordDto(OperationType operationType, String fruitName, Integer quantity) {
        this.operationType = operationType;
        this.fruitName = fruitName;
        this.quantity = quantity;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public String getFruitName() {
        return fruitName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
