package core.basesyntax.strategy.impl;

import core.basesyntax.dao.ProductDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationService;

public class BalanceOperationServiceImpl implements OperationService {
    private ProductDao productDao;

    public BalanceOperationServiceImpl(ProductDao productDao) {
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
