package core.basesyntax.strategy;

import core.basesyntax.model.Transaction;
import core.basesyntax.storage.Storage;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void process(Transaction transaction) {
        Integer initialQuantity = Storage.storage.get(transaction.getFruit());
        Storage.storage.put(transaction.getFruit(),
                initialQuantity == null
                        ? transaction.getQuantity()
                        : initialQuantity + transaction.getQuantity());
    }
}
