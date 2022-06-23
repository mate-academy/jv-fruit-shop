package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Transaction;
import core.basesyntax.strategy.OperationHandler;

public class BalanceHandlerImpl implements OperationHandler {
    @Override
    public void applyChanges(Transaction transaction) {
        Storage.fruits.put(transaction.getFruit(), transaction.getAmountFruits());
    }
}
