package core.basesyntax.handlers;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void calculateOperation(FruitTransaction transaction) {
        Storage.STORAGE.put(transaction.getFruit(), transaction.getQuantity());
    }
}
