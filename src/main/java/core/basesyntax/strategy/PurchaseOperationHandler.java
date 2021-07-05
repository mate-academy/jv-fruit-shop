package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.dto.Transaction;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public int apply(Transaction transaction) {
        int previousValue = Storage.storage.get(transaction.getFruit());
        int newValue = previousValue - transaction.getQuantity();
        if (previousValue - transaction.getQuantity() < 0) {
            newValue = 0;
        }
        Storage.storage.put(transaction.getFruit(), newValue);
        return Storage.storage.get(transaction.getFruit());
    }
}
