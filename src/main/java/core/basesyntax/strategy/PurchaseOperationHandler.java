package core.basesyntax.strategy;

import core.basesyntax.model.Transaction;
import core.basesyntax.storage.Storage;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void apply(Transaction transaction) {
        Integer currentQuantity = Storage.storage.get(transaction.getFruit());
        if (currentQuantity >= transaction.getQuantity()) {
            Storage.storage.put(transaction.getFruit(),
                    currentQuantity - transaction.getQuantity());
        }
    }
}

