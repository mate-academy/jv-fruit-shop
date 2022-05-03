package core.basesyntax.strategy;

import core.basesyntax.model.Transaction;
import core.basesyntax.storage.Storage;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void process(Transaction transaction) {
        Integer initialQuantity = Storage.storage.get(transaction.getFruit());
        if (initialQuantity == null) {
            throw new RuntimeException("No such fruit found");
        }
        if (initialQuantity - transaction.getQuantity() < 0) {
            throw new RuntimeException("Such a number of fruits not found");
        }
        Storage.storage.put(transaction.getFruit(), initialQuantity - transaction.getQuantity());
    }
}
