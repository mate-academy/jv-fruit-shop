package core.basesyntax.service.strategy.impl;

import core.basesyntax.dao.ProductDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.strategy.OperationHandler;

public class ReturnOperationHandler implements OperationHandler {
    private final ProductDao productDao;

    public ReturnOperationHandler(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        int totalQuantity = productDao.getQuantity(fruitTransaction)
                + fruitTransaction.getQuantity();
        if (totalQuantity < 0) {
            throw new IllegalArgumentException(
                    "Balance can`t be negative, but was: " + totalQuantity);
        }
        productDao.update(fruitTransaction, totalQuantity);
    }
}
