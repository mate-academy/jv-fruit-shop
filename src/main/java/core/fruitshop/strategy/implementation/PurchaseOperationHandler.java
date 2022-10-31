package core.fruitshop.strategy.implementation;

import core.fruitshop.dao.StorageDao;
import core.fruitshop.exceptions.NoSuchProductException;
import core.fruitshop.exceptions.ProductAmountException;
import core.fruitshop.strategy.interfaces.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    private final StorageDao storageDao;

    public PurchaseOperationHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void handle(String productName, int amount) {
        if (amount < 0) {
            throw new ProductAmountException(AMOUNT_LESS_THEN_ZERO_EXCEPTION_MESSAGE + productName);
        }
        if (storageDao.contains(productName)) {
            int currentAmount = storageDao.getAmount(productName);
            if (amount > currentAmount) {
                throw new ProductAmountException(AMOUNT_TO_MINUS_INCORRECT_EXCEPTION_MESSAGE
                        + currentAmount);
            }
            storageDao.setAmount(productName, currentAmount - amount);
            return;
        }
        throw new NoSuchProductException(productName + NOT_EXISTS_EXCEPTION_MESSAGE);
    }
}
