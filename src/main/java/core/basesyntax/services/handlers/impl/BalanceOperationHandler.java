package core.basesyntax.services.handlers.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.models.FruitTransaction;
import core.basesyntax.services.handlers.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void handleOperation(FruitTransaction fruitTransaction) {
        Storage.updateFruit(fruitTransaction.getFruit(),
                fruitTransaction.getQuantity());
    }
}
