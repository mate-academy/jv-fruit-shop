package core.basesyntax.handler.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.handler.OperationHandler;
import core.basesyntax.model.FruitTransaction;

public class BalanceHandler implements OperationHandler {
    @Override
    public void handleOperation(FruitTransaction fruitTransaction) {
        Storage.STORAGE.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
