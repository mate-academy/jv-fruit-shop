package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void applyChanges(FruitTransaction fruitTransaction) {
        Storage.storage.put(fruitTransaction.getNameOfFruit(),fruitTransaction.getQuantity());
    }
}
