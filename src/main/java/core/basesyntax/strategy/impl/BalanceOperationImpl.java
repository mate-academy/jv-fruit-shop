package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ProductDao;
import core.basesyntax.strategy.OperationService;

public class BalanceOperationImpl implements OperationService {
    private ProductDao productDao;

    public BalanceOperationImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public void calculate(FruitTransaction fruitTransaction) {
        int total = productDao.getQuantityOf(fruitTransaction)
                + fruitTransaction.getQuantity();
        if (total < 0) {
            throw new IllegalArgumentException("Balance can`t be negative, but was: " + total);
        }
        productDao.update(fruitTransaction, total);
    }
}
