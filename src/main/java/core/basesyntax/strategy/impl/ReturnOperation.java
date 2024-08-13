package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class ReturnOperation implements OperationHandler {
    public void handleOperation(FruitTransaction fruitTransaction, Storage storage) {
        if (storage.getInventory().containsKey(fruitTransaction.getFruit())) {
            storage.getInventory().compute(fruitTransaction.getFruit(),
                    (k, currentQty) -> currentQty
                                + fruitTransaction.getQuantity());
        } else {
            storage.getInventory().put(fruitTransaction.getFruit(),
                        fruitTransaction.getQuantity());
        }
    }
}
