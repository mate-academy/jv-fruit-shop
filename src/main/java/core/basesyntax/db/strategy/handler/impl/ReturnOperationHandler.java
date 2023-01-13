package core.basesyntax.db.strategy.handler.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.db.model.FruitTransaction;
import core.basesyntax.db.strategy.OperationHandler;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        int previousQuantity = Storage.getStorage().get(transaction.getFruit());
        Storage.getStorage().put(transaction.getFruit(),
                previousQuantity + transaction.getQuantity());
    }
}
