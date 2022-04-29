package core.basesyntax.strategy.implementation;

import core.basesyntax.models.Fruit;
import core.basesyntax.models.Transaction;
import core.basesyntax.storage.Storage;

public class BalanceTransaction implements TransactionHandler{
    Storage storage = new Storage();

    @Override
    public boolean handleTransaction(Transaction transaction) {
        storage.add(new Fruit(transaction.getName()), transaction.getQuantity());
        return true;
    }
}
