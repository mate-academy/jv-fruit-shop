package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        int previousQuantity = Storage.get(transaction.getFruit());
        if (transaction.getQuantity() < 0) {
            throw new RuntimeException("There is no enough fruits");
        }
        Storage.put(transaction.getFruit(), previousQuantity + transaction.getQuantity());
    }
}
