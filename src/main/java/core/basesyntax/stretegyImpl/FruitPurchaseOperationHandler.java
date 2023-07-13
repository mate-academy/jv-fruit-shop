package core.basesyntax.stretegyImpl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.strategy.FruitOperationHandler;

public class FruitPurchaseOperationHandler implements FruitOperationHandler {
    private final StorageDao storageDao;

    public FruitPurchaseOperationHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void operate(String fruitName, int amount) {
        storageDao.remove(fruitName, amount);
    }
}
