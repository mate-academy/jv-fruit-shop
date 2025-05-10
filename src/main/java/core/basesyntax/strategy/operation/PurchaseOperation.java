package core.basesyntax.strategy.operation;

import core.basesyntax.dao.StorageDao;

public class PurchaseOperation implements FruitOperationHandler {
    private static final int MODIFIRE_OF_AMOUNT = -1;
    private final StorageDao storageDao;

    public PurchaseOperation(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void applyOperation(String fruit, int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Illegal amount value" + amount);
        }
        storageDao.update(fruit, (amount * MODIFIRE_OF_AMOUNT));
    }
}
