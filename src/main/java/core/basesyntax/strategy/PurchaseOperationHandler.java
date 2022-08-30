package core.basesyntax.strategy;

import core.basesyntax.model.Transaction;
import core.basesyntax.storage.Storage;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void apply(Transaction transaction) {
        if (Storage.storage.get(transaction.getFruit()) >= transaction.getQuantity()) {
            Storage.storage.put(transaction.getFruit(),
                    Storage.storage.get(transaction.getFruit()) - transaction.getQuantity());
        }
    }
}
