package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        if (transaction.getQuantity() == 0 || transaction.getQuantity() < 0) {
            throw new RuntimeException("No fruits available");
        }
        Storage.put(transaction.getFruit(), transaction.getQuantity());
    }
}
