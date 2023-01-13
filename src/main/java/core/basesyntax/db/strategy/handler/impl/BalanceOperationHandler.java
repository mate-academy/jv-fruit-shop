package core.basesyntax.db.strategy.handler.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.db.model.FruitTransaction;
import core.basesyntax.db.strategy.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        Storage.getStorage().put(transaction.getFruit(), transaction.getQuantity());
    }
}
