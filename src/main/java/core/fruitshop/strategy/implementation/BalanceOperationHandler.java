package core.fruitshop.strategy.implementation;

import core.fruitshop.dao.StorageDao;
import core.fruitshop.exceptions.ProductAmountException;
import core.fruitshop.strategy.interfaces.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {
    private final StorageDao storageDao;

    public BalanceOperationHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void handle(String productName, int amount) {
        if (amount < 0) {
            throw new ProductAmountException(AMOUNT_LESS_THEN_ZERO_EXCEPTION_MESSAGE + productName);
        }
        storageDao.addProduct(productName, amount);
    }
}
