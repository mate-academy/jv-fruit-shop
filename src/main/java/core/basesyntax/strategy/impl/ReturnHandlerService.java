package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class ReturnHandlerService implements OperationHandler {
    @Override
    public void processOperation(FruitTransaction fruitTransaction) {
        Integer newBalance = Storage.fruitBalance.get(fruitTransaction.getFruit())
                + fruitTransaction.getQuantity();
        Storage.fruitBalance.replace(fruitTransaction.getFruit(), newBalance);
    }
}
