package core.basesyntax.handler.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.handler.OperationHandler;
import core.basesyntax.model.FruitTransaction;

public class SupplyHandler implements OperationHandler {
    @Override
    public void handleOperation(FruitTransaction fruitTransaction) {
        int beforeSupplying = Storage.STORAGE.get(fruitTransaction.getFruit());
        int afterSupplying = beforeSupplying + fruitTransaction.getQuantity();
        Storage.STORAGE.put(fruitTransaction.getFruit(), afterSupplying);
    }
}
