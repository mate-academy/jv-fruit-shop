package core.basesyntax.model.dto;

import core.basesyntax.model.Fruit;
import core.basesyntax.operations.Operations;

public class FruitDataDto {
    private Operations operationType;
    private Fruit fruit;
    private Integer fruitQuantity;

    public FruitDataDto(Operations operationType, Fruit fruit, Integer fruitQuantity) {
        this.operationType = operationType;
        this.fruit = fruit;
        this.fruitQuantity = fruitQuantity;
    }

    public Operations getOperationType() {
        return operationType;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public Integer getFruitQuantity() {
        return fruitQuantity;
    }
}
