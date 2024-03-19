package core.basesyntax.strategy.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.strategy.OperationStrategy;

public class BalanceOperationStrategy implements OperationStrategy {
    private final StorageDao storageDao;

    public BalanceOperationStrategy(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void process(String product, int quantity) {
        storageDao.putProduct(product, quantity);
    }
}
