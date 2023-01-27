package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Transaction;
import core.basesyntax.strategy.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void calculate(Transaction transaction) {
        Storage.fruitsStorage.put(transaction.getFruit(), transaction.getQuantity());
    }
}
