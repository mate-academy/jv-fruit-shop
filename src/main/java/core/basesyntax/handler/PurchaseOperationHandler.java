package core.basesyntax.handler;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperationHandler implements OperationHandler {
    private final StorageDao storageDao;

    public PurchaseOperationHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void applyOperation(FruitTransaction transaction) {
        if (transaction == null) {
            throw new NullPointerException("Transaction is null");
        }

        Integer previousValue = storageDao.get(transaction.getFruit());
        if (previousValue == null || previousValue - transaction.getQuantity() < 0) {
            throw new RuntimeException("Fruit quantity should be greater than zero");
        }
        storageDao.set(transaction.getFruit(), previousValue - transaction.getQuantity());
    }
}
