package fruitshop.model.dto;

import fruitshop.service.operation.OperationType;

public class FruitDto {
    private final OperationType operationType;
    private final String fruitName;
    private final Integer quantity;

    public FruitDto(OperationType operationType, String fruitName, Integer quantity) {
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
}
