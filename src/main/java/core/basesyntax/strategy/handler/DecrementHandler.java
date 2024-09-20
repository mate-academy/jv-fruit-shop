package core.basesyntax.strategy.handler;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.OperationHandler;

public abstract class DecrementHandler implements OperationHandler {
    @Override
    public void apply(Fruit fruit, int quantity) {
        fruit = Storage.fruits.get(fruit.getName());
        if (fruit == null || fruit.getQuantity() < quantity) {
            throw new RuntimeException("Not enough fruit available.");
        }
        fruit.subtractQuantity(quantity);
    }
}

