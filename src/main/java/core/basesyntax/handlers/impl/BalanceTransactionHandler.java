package core.basesyntax.handlers.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.handlers.TransactionHandler;
import core.basesyntax.model.FruitTransaction;

public class BalanceTransactionHandler implements TransactionHandler {
    private final StoringHandler storingHandler;

    public BalanceTransactionHandler(StorageDao storageDao) {
        storingHandler = new StoringHandler(storageDao);
    }

    @Override
    public void handle(FruitTransaction transaction) {
        storingHandler.handle(transaction);
    }
}
