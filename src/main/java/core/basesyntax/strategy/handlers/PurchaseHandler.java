package core.basesyntax.strategy.handlers;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseHandler implements OperationHandler {
    private final StorageDao storageDao;

    public PurchaseHandler(StorageDao storage) {
        this.storageDao = storage;
    }

    @Override
    public void handleOperation(String productType, int amount) {
        int newAmount = storageDao.getAmountByProduct(productType) - amount;
        storageDao.putToInventory(productType, newAmount);
    }
}
