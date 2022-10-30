package core.fruitshop.strategy.implementation;

import core.fruitshop.dao.StorageDao;
import core.fruitshop.strategy.interfaces.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {
    private final StorageDao storageDao;

    public BalanceOperationHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void handle(String productName, int amount) {
        storageDao.addProduct(productName, amount);
    }
}
