package core.basesyntax.strategy;

import core.basesyntax.model.Transaction;
import core.basesyntax.storage.Storage;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void process(Transaction transaction) {
        Storage.storage.put(transaction.getFruit(), transaction.getQuantity());
    }
}
