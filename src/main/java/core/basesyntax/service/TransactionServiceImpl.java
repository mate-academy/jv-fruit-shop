package core.basesyntax.service;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.transaction.TransactionHandler;

public class TransactionServiceImpl implements TransactionService {
    private Storage storage;

    public TransactionServiceImpl(Storage storage) {
        if (storage == null) {
            throw new RuntimeException("Storage can not be null.");
        }
        this.storage = storage;
    }

    @Override
    public void handleTransaction(
              TransactionHandler transactionHandler,
              String fruitName,
              int amount
    ) {
        if (transactionHandler == null) {
            throw new RuntimeException("TransactionHAndler can not be null.");
        }
        Fruit fruit = storage.get(fruitName);
        if (fruit == null) {
            fruit = new Fruit(fruitName);
        }
        storage.put(transactionHandler.callTransaction(fruit, amount));
    }
}
