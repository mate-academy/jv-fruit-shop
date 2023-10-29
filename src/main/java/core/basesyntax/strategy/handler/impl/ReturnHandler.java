package core.basesyntax.strategy.handler.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.handler.OperationHandler;

public class ReturnHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        int oldQuantity = Storage.storage.get(fruitTransaction.getFruit());
        Storage.storage.put(fruitTransaction.getFruit(),
                oldQuantity + fruitTransaction.getQuantity());
    }
}
