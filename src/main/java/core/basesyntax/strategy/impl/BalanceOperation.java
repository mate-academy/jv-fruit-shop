package core.basesyntax.strategy.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.storage.Storage;
import core.basesyntax.strategy.OperationHandler;

public class BalanceOperation implements OperationHandler {
    @Override
    public void execute(Fruit fruit, Integer quantity) {
        Storage.stock.put(fruit, quantity);
    }
}
