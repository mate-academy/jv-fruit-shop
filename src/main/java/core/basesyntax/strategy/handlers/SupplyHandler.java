package core.basesyntax.strategy.handlers;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.strategy.OperationHandler;

public class SupplyHandler implements OperationHandler {
    private final StorageDao storageDao;

    public SupplyHandler(StorageDao storage) {
        this.storageDao = storage;
    }

    @Override
    public void handleOperation(String productType, int amount) {
        int newAmount = storageDao.getAmountByProduct(productType) + amount;
        storageDao.putToInventory(productType, newAmount);
    }
}
