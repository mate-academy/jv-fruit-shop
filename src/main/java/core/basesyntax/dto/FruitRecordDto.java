package core.basesyntax.dto;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.OperationType;

public class FruitRecordDto {
    private Fruit fruit;
    private long amount;
    private OperationType operationType;

    public FruitRecordDto(OperationType operationType, String fruitName, long amount) {
        this.fruit = new Fruit(fruitName, amount);
        this.amount = amount;
        this.operationType = operationType;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public OperationType getOperationType() {
        return operationType;
    }

}
