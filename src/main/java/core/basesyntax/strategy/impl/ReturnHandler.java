package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class ReturnHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        int previousQuantity = Storage.getStorageMap().get(transaction.getFruit());
        Storage.getStorageMap().put(transaction.getFruit(),
                previousQuantity + transaction.getQuantity());
    }
}
