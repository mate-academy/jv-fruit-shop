package core.basesyntax.strategy.operation;

import core.basesyntax.dao.StorageDao;

public class BalanceOperation implements FruitOperationHandler {
    private StorageDao storageDao;

    public BalanceOperation(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void applyOperation(String fruit, int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Illegal amount value" + amount);
        }
        storageDao.addFruit(fruit, amount);
    }
}
