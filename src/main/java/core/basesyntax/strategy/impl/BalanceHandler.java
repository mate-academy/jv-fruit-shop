package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class BalanceHandler implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        Storage.getStorageMap().put(transaction.getFruit(), transaction.getQuantity());
    }
}
