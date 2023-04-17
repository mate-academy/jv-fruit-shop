package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class ReturnOperationHandler implements OperationHandler {

    @Override
    public void transaction(FruitTransaction fruitTransaction) {
        int currentQty = Storage.fruitsStorage.get(fruitTransaction.getFruit());
        Storage.fruitsStorage.put(fruitTransaction.getFruit(),
                currentQty + fruitTransaction.getQuantity());
    }
}
