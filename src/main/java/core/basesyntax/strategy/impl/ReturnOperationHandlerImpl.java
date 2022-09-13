package core.basesyntax.strategy.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.Transaction;
import core.basesyntax.strategy.TransactionsHandler;

public class ReturnOperationHandlerImpl implements TransactionsHandler {
    private final StorageDao storageDao;

    public ReturnOperationHandlerImpl(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void handle(Transaction transaction) {
        if (transaction.getQuantity() < 0) {
            throw new RuntimeException("Return can't be negative");
        }
        int remainingGoods = storageDao.getRemainingGoods(transaction.getProduct()) != null
                ? storageDao.getRemainingGoods(transaction.getProduct()) : 0;
        int newQuantity = transaction.getQuantity() + remainingGoods;
        storageDao.update(transaction.getProduct(), newQuantity);
    }
}
