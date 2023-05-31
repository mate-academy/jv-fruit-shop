package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ProductDao;
import core.basesyntax.strategy.OperationHandler;

public class ReturnOperationHandler implements OperationHandler {
    private ProductDao productDao;

    public ReturnOperationHandler(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        int total = productDao.getQuantityOf(fruitTransaction)
                + fruitTransaction.getQuantity();
        if (total < 0) {
            throw new IllegalArgumentException("Balance can`t be negative, but was: " + total);
        }
        productDao.update(fruitTransaction, total);
    }
}
