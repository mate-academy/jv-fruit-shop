package core.basesyntax.strategy.handlers;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.strategy.OperationHandler;

public class BalanceHandler implements OperationHandler {
    private final StorageDao storageDao;

    public BalanceHandler(StorageDao storage) {
        this.storageDao = storage;
    }

    @Override
    public void handle(String productType, int amount) {
        storageDao.putToInventory(productType, amount);
    }
}
