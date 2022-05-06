package core.basesyntax.strategy.imp;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.strategy.FruitOperation;

public class SupplyFruitOperation implements FruitOperation {
    private final StorageDao storageDao;

    public SupplyFruitOperation(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void apply(String fruit, int amount) {
        if (storageDao.isPresent(fruit)) {
            storageDao.add(fruit, amount);
        } else {
            storageDao.add(fruit, storageDao.getAmount(fruit) + amount);
        }
    }
}
