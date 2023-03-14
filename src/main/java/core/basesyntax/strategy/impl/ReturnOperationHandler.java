package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void activity(FruitTransaction fruitTransaction) {
        int amount = Storage.getOrDefault(fruitTransaction.getFruit(), DEFAULT_VALUE);
        Storage.put(fruitTransaction.getFruit(), amount + fruitTransaction.getQuantity());
    }
}
