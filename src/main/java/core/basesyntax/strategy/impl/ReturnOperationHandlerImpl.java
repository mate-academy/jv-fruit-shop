package core.basesyntax.strategy.impl;

import core.basesyntax.model.Transaction;
import core.basesyntax.storage.Storage;
import core.basesyntax.strategy.OperationHandler;

public class ReturnOperationHandlerImpl implements OperationHandler {
    @Override
    public void apply(Transaction transaction) {
        Integer currentQuantity = Storage.storage.get(transaction.getFruit());
        Storage.storage.put(transaction.getFruit(), currentQuantity + transaction.getQuantity());
    }
}
