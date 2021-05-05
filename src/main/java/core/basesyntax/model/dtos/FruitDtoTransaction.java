package core.basesyntax.model.dtos;

import core.basesyntax.model.OperationType;

public class FruitDtoTransaction {
    private OperationType operationType;
    private String fruitName;
    private Integer fruitCount;

    public FruitDtoTransaction(OperationType operationType, String fruitName, Integer fruitCount) {
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
