package core.basesyntax.strategy.impl;

import core.basesyntax.model.Transaction;
import core.basesyntax.storage.Storage;
import core.basesyntax.strategy.OperationHandler;

public class BalanceOperationHandlerImpl implements OperationHandler {
    @Override
    public void apply(Transaction transaction) {
        Storage.storage.put(transaction.getFruit(), transaction.getQuantity());
    }
}
