package core.basesyntax.dto;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;

public class FruitRecordDto {
    private final Operation operationType;
    private final Fruit fruit;
    private final Integer quantity;

    public FruitRecordDto(Operation operationType, Fruit fruit, Integer quantity) {
        this.operationType = operationType;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public Operation getOperationType() {
        return operationType;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
