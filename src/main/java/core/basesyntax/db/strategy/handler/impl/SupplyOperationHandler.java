package core.basesyntax.db.strategy.handler.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.db.model.FruitTransaction;
import core.basesyntax.db.strategy.OperationHandler;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        int previousQuantity = Storage.getAll().get(transaction.getFruit());
        Storage.getAll().put(transaction.getFruit(),
                previousQuantity + transaction.getQuantity());
    }
}
