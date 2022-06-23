package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Transaction;
import core.basesyntax.strategy.OperationHandler;

public class ReturnHandlerImpl implements OperationHandler {

    @Override
    public void applyChanges(Transaction transaction) {
        if (Storage.fruits.get(transaction.getFruit()) == null) {
            throw new RuntimeException("We don't have fruits for return - "
                    + transaction.getFruit());
        }
        Storage.fruits.replace(transaction.getFruit(),
                Storage.fruits.get(transaction.getFruit())
                        + transaction.getAmountFruits());
    }
}
