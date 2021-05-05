package core.basesyntax.model.dto;

import core.basesyntax.service.operations.OperationType;

public class FruitRecordDto {
    private OperationType operationType;
    private String fruitName;
    private Integer fruitCount;

    public FruitRecordDto(OperationType operationType, String fruitName, Integer fruitCount) {
        this.operationType = operationType;
        this.fruitName = fruitName;
        this.fruitCount = fruitCount;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public String getFruitName() {
        return fruitName;
    }

    public Integer getFruitCount() {
        return fruitCount;
    }
}
