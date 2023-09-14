package core.basesyntax.strategy.handler.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.handler.OperationHandler;

public class BalanceHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        Storage.storage.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
