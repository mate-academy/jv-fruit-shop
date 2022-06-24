package core.basesyntax.model;

import core.basesyntax.strategy.OperationType;

public class Operation {
    private final OperationType type;
    private final String fruitName;
    private final int amount;

    public Operation(OperationType type, String fruitName, int amount) {
        this.type = type;
        this.fruitName = fruitName;
        this.amount = amount;
    }

    public OperationType getType() {
        return type;
    }

    public String getFruitName() {
        return fruitName;
    }

    public int getAmount() {
        return amount;
    }
}
