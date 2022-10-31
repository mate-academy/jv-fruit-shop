package core.fruitshop.strategy.implementation;

import core.fruitshop.dao.StorageDao;
import core.fruitshop.exceptions.NoSuchProductException;
import core.fruitshop.exceptions.ProductAmountException;
import core.fruitshop.strategy.interfaces.OperationHandler;

public class ReturnSupplyOperationHandler implements OperationHandler {
    private final StorageDao storageDao;

    public ReturnSupplyOperationHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void handle(String productName, int amount) {
        if (amount < 0) {
            throw new ProductAmountException(AMOUNT_LESS_THEN_ZERO_EXCEPTION_MESSAGE + productName);
        }
        if (storageDao.contains(productName)) {
            int currentAmount = storageDao.getAmount(productName);
            storageDao.setAmount(productName, currentAmount + amount);
            return;
        }
        throw new NoSuchProductException(productName + NOT_EXISTS_EXCEPTION_MESSAGE);
    }
}
