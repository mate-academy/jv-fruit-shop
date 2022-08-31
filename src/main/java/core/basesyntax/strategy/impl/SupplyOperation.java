package core.basesyntax.strategy.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.storage.Storage;
import core.basesyntax.strategy.OperationHandler;

public class SupplyOperation implements OperationHandler {
    @Override
    public void execute(Fruit fruit, Integer quantity) {
        if (Storage.stock.containsKey(fruit)) {
            Storage.stock.put(fruit, Storage.stock.get(fruit) + quantity);
        }
    }
}
