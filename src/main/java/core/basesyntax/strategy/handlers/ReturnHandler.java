package core.basesyntax.strategy.handlers;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.strategy.OperationHandler;

public class ReturnHandler implements OperationHandler {
    private final StorageDao storageDao;

    public ReturnHandler(StorageDao storage) {
        this.storageDao = storage;
    }

    @Override
    public void handle(String productType, int amount) {
        int newAmount = storageDao.getAmountByProduct(productType) + amount;
        storageDao.putToInventory(productType, newAmount);
    }
}
