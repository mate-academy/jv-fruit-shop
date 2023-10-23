package core.basesyntax.transactionhandler.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.transactionhandler.TransactionHandler;

public class BalanceHandler implements TransactionHandler {
    private final StorageDao storageDao;

    public BalanceHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void handleTransaction(FruitTransaction transaction) {
        if (transaction.getQuantity() < 0) {
            throw new RuntimeException("The amount of fruit in stock must be positive");
        }
        storageDao.add(transaction.getFruit(), transaction.getQuantity());
    }
}
