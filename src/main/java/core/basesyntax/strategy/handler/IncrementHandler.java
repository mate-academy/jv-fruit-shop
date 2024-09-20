package core.basesyntax.strategy.handler;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.OperationHandler;

public abstract class IncrementHandler implements OperationHandler {
    @Override
    public void apply(Fruit fruit, int quantity) {
        fruit = Storage.fruits.getOrDefault(fruit.getName(), new Fruit(fruit.getName()));
        fruit.addQuantity(quantity);
        Storage.fruits.put(fruit.getName(), fruit);
    }
}
