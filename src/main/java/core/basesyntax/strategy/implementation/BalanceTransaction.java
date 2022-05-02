package core.basesyntax.strategy.implementation;

import core.basesyntax.models.Transaction;
import core.basesyntax.storage.Storage;

public class BalanceTransaction implements TransactionHandler {
    private Storage storage = new Storage();

    @Override
    public boolean handleTransaction(Transaction transaction) {
        storage.add(transaction.getFruit(), transaction.getQuantity());
        return true;
    }
}
