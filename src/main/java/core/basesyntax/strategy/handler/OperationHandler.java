package core.basesyntax.strategy.handler;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.models.Fruit;

public abstract class OperationHandler {
    protected final FruitStorage fruitStorage;

    public OperationHandler(FruitStorage fruitStorage) {
        this.fruitStorage = fruitStorage;
    }

    public abstract void handle(Fruit fruit, Integer quantity);
}
