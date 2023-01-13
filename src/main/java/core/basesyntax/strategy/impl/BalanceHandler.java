package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.services.OperationHandler;

public class BalanceHandler implements OperationHandler {
    @Override
    public void operate(FruitTransaction fruitTransaction) {
        Storage.fruitsStorage
                .put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
