package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Transaction;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void apply(Transaction transaction) {
        Storage.storage.put(transaction.getFruit(), transaction.getQuantity());
    }
}
