package core.basesyntax.strategy.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.Transaction;
import core.basesyntax.strategy.TransactionsHandling;

public class ReturnHandlingImpl implements TransactionsHandling {
    private final StorageDao storageDao;

    public ReturnHandlingImpl(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void applyTransaction(Transaction transaction) {
        if (transaction.getQuantity() < 0) {
            throw new RuntimeException("Return can't be negative");
        }
        int remainingGoods = storageDao.getRemainingGoods(transaction.getProduct()) != null
                ? storageDao.getRemainingGoods(transaction.getProduct()) : 0;
        int newQuantity = transaction.getQuantity() + remainingGoods;
        storageDao.updateDataStorage(transaction.getProduct(), newQuantity);
    }
}
