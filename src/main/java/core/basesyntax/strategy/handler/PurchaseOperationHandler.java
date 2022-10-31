package core.basesyntax.strategy.handler;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperationHandler implements OperationHandler {
    private final StorageDao storageDao;

    public PurchaseOperationHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public int execute(FruitTransaction transaction) {
        if (storageDao.get(transaction.getFruit()) >= transaction.getQuantity()) {
            return storageDao.update(transaction.getFruit(), -transaction.getQuantity());
        }
        throw new RuntimeException("Not enough " + transaction.getFruit() + " in storage");
    }
}
