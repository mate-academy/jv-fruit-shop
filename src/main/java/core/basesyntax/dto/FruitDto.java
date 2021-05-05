package core.basesyntax.dto;

import core.basesyntax.operations.Operation;

public class FruitDto {
    private Operation operation;
    private String fruitName;
    private Integer countFruit;

    public FruitDto(Operation operation, String fruitName, Integer countFruit) {
        this.operation = operation;
        this.fruitName = fruitName;
        this.countFruit = countFruit;
    }

    public Operation getOperation() {
        return operation;
    }

    public String getFruitName() {
        return fruitName;
    }

    public Integer getCountFruit() {
        return countFruit;
    }
}
