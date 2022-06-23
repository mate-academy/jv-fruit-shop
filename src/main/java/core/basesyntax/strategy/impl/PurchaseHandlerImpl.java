package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Transaction;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseHandlerImpl implements OperationHandler {
    @Override
    public void applyChanges(Transaction transaction) {
        if (Storage.fruits.get(transaction.getFruit()) == null) {
            throw new RuntimeException("No fruit available: " + transaction.getFruit());
        }
        if (Storage.fruits.get(transaction.getFruit()) < transaction.getAmountFruits()) {
            throw new RuntimeException("So many fruits are not available, only - "
                    + Storage.fruits.get(transaction.getFruit()));
        }
        Storage.fruits.replace(transaction.getFruit(),
                Storage.fruits.get(transaction.getFruit())
                        - transaction.getAmountFruits());
    }
}
