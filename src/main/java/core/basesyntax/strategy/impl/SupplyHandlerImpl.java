package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Transaction;
import core.basesyntax.strategy.OperationHandler;

public class SupplyHandlerImpl implements OperationHandler {
    @Override
    public void applyChanges(Transaction transaction) {
        if (Storage.fruits.get(transaction.getFruit()) == null) {
            throw new RuntimeException("Fruits don't present: " + transaction.getFruit());
        }
        Storage.fruits.replace(transaction.getFruit(),
                Storage.fruits.get(transaction.getFruit())
                        + transaction.getAmountFruits());
    }
}
