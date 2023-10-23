package core.basesyntax.transactionhandler.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.transactionhandler.TransactionHandler;

public class PurchaseHandler implements TransactionHandler {
    private final StorageDao storageDao;

    public PurchaseHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void handleTransaction(FruitTransaction transaction) {
        int currentQuantity = storageDao.getQuantity(transaction.getFruit());
        int newQuantity = currentQuantity - transaction.getQuantity();
        if (newQuantity >= 0) {
            storageDao.add(transaction.getFruit(), newQuantity);
        } else {
            throw new RuntimeException("Not enough fruit to sell.There are "
                    + currentQuantity + " pcs");
        }
    }
}
