package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class ReturnTransactionHandler implements TransactionHandler {
    @Override
    public void applyTransaction(FruitTransaction transaction) {
        if (Storage.storage.containsKey(transaction.getFruit())) {
            Storage.storage.replace(transaction.getFruit(),
                    Storage.storage.get(transaction.getFruit())
                            + transaction.getQuantity());
        } else {
            Storage.storage.put(transaction.getFruit(),
                    transaction.getQuantity());
        }
    }
}
