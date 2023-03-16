package core.basesyntax.strategy.Impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void operate(FruitTransaction transaction){
        Storage.storage.put(transaction.getFruit(),
                transaction.getQuantity());
    }
}
