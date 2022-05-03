package core.basesyntax.strategy;

import core.basesyntax.db.DatabaseImpl;
import core.basesyntax.models.Transaction;

public class BalanceTransaction implements TransactionHandler {
    private DatabaseImpl storage = new DatabaseImpl();

    @Override
    public boolean handleTransaction(Transaction transaction) {
        storage.add(transaction.getFruit(), transaction.getQuantity());
        return true;
    }
}
