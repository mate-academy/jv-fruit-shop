package core.fruitshop.strategy.implementation;

import core.fruitshop.dao.StorageDao;
import core.fruitshop.strategy.interfaces.OperationHandler;

public class SupplyOperationHandler implements OperationHandler {
    private final StorageDao storageDao;

    public SupplyOperationHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void handle(String productName, int amount) {
        storageDao.addAmount(productName, amount);
    }
}
