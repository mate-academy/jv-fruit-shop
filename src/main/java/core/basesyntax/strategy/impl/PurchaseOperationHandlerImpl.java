package core.basesyntax.strategy.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.Transaction;
import core.basesyntax.strategy.TransactionsHandler;

public class PurchaseOperationHandlerImpl implements TransactionsHandler {
    private final StorageDao storageDao;

    public PurchaseOperationHandlerImpl(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void handle(Transaction transaction) {
        Integer remainingGoods = storageDao.getRemainingGoods(transaction.getProduct());
        if (remainingGoods < transaction.getQuantity()) {
            throw new RuntimeException("Not enough goods");
        }
        int newQuantity = remainingGoods - transaction.getQuantity();
        storageDao.update(transaction.getProduct(), newQuantity);
    }
}
