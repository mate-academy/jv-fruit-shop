package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {

    @Override
    public void transaction(FruitTransaction fruitTransaction) {
        Storage.fruitsStorage.put(fruitTransaction.getFruit(),
                fruitTransaction.getQuantity());
    }
}
