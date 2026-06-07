package core.basesyntax.service.strategy.handler.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.strategy.handler.OperationHandler;

public class BalanceOperation implements OperationHandler {
    private Storage storage;

    @Override
    public void handle(FruitTransaction fruitTransaction, Storage storage) {
        storage.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
