package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ProductDao;
import core.basesyntax.strategy.OperationHandler;

public class SupplyOperationHandler implements OperationHandler {
    private ProductDao productDao;

    public SupplyOperationHandler(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        int curAmount = productDao.getQuantityOf(fruitTransaction);
        if (curAmount < 0) {
            throw new IllegalArgumentException("Balance can`t be negative, but was: " + curAmount);
        }
        curAmount = curAmount + fruitTransaction.getQuantity();
        productDao.update(fruitTransaction, curAmount);
    }
}
