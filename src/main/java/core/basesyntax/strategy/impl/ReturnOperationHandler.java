package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void operate(FruitTransaction transaction) {
        Storage.storage.put(transaction.getFruit(),
                transaction.getQuantity() + Storage.storage.get(transaction.getFruit()));
    }
}
