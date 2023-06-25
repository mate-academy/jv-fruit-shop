package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class SupplyHandler implements OperationHandler {

    @Override
    public void executeOperation(FruitTransaction transaction) {
        int currentQuantity = Storage.storage.get(transaction.getFruit());
        Storage.storage.put(transaction.getFruit(), currentQuantity + transaction.getQuantity());
    }
}
