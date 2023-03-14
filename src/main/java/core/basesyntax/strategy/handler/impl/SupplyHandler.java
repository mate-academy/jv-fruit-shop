package core.basesyntax.strategy.handler.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.handler.OperationHandler;

public class SupplyHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        int currentQuantity = Storage.STORAGE
                .getOrDefault(transaction.getFruit(), 0);
        Storage.STORAGE.put(transaction.getFruit(),
                currentQuantity + transaction.getQuantity());
    }
}
