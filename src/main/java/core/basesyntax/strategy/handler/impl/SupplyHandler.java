package core.basesyntax.strategy.handler.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.handler.OperationHandler;

public class SupplyHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        int oldQuantity = Storage.get(transaction.getFruit());
        Storage.put(transaction.getFruit(), transaction.getQuantity() + oldQuantity);
    }
}
