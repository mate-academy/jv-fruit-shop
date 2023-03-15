package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class ReturnHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        Storage.storage.put(fruitTransaction.getFruit(),
                fruitTransaction.getQuantity()
                        + Storage.storage.get(fruitTransaction.getFruit()));
    }
}
