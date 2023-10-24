package core.basesyntax.service.handler.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {
    private final StorageDao storageDao;

    public BalanceOperationHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void updateStorage(FruitTransaction transaction) {
        validAmount(transaction);
        if (!storageDao.isInStorage(transaction.getFruitName())) {
            storageDao.add(new Fruit(transaction.getFruitName()), transaction.getAmount());
        } else {
            storageDao.get(transaction.getFruitName()).setValue(transaction.getAmount());
        }
    }

}
