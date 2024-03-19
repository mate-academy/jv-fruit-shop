package core.basesyntax.strategy.handler.impl;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.models.Fruit;
import core.basesyntax.strategy.handler.OperationHandler;

public class SupplyHandler extends OperationHandler {

    public SupplyHandler(FruitStorage fruitStorage) {
        super(fruitStorage);
    }

    @Override
    public void handle(Fruit fruit, Integer quantity) {
        if (fruitStorage.storage().containsKey(fruit)) {
            fruitStorage.storage().put(fruit, fruitStorage.storage().get(fruit) + quantity);
        }
        fruitStorage.storage().putIfAbsent(fruit, quantity);
    }
}
