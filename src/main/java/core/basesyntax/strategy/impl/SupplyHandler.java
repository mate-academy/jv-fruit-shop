package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class SupplyHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        if (fruitTransaction.getQuantity() > 0) {
            Storage.storage.put(fruitTransaction.getFruit(),
                    Storage.storage.get(fruitTransaction.getFruit())
                    + fruitTransaction.getQuantity());
        } else {
            throw new RuntimeException("Quantity is 0 or less : " + fruitTransaction.getQuantity());
        }
    }
}
