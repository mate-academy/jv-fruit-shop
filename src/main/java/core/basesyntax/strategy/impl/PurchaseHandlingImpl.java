package core.basesyntax.strategy.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.Transaction;
import core.basesyntax.strategy.TransactionsHandling;

public class PurchaseHandlingImpl implements TransactionsHandling {
    private final StorageDao storageDao;

    public PurchaseHandlingImpl(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void applyTransaction(Transaction transaction) {
        Integer remainingGoods = storageDao.getRemainingGoods(transaction.getProduct());
        if (remainingGoods < transaction.getQuantity()) {
            throw new RuntimeException("Not enough goods");
        }
        int newQuantity = remainingGoods - transaction.getQuantity();
        storageDao.updateDataStorage(transaction.getProduct(), newQuantity);
    }
}
