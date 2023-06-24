package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void doActivity(FruitTransaction fruitTransaction) {
        int amount = Storage.getOrDefault(fruitTransaction.getFruit(), DEFAULT_VALUE);
        Storage.put(fruitTransaction.getFruit(), amount + fruitTransaction.getQuantity());
    }
}
