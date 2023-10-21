package core.basesyntax.service.handler.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {
    private static final int MIN_AMOUNT = 0;
    private final StorageDao storageDao = new StorageDaoImpl();

    @Override
    public void updateStorage(FruitTransaction transaction) {
        if (transaction.getAmount() < MIN_AMOUNT) {
            throw new RuntimeException("Balance is less then zero!!!");
        }
        if (!storageDao.isInStorage(transaction.getFruitName())) {
            storageDao.add(new Fruit(transaction.getFruitName()), transaction.getAmount());
        } else {
            storageDao.get(transaction.getFruitName()).setValue(transaction.getAmount());
        }
    }

}
