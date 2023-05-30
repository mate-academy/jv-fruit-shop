package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ProductDao;
import core.basesyntax.strategy.OperationService;

public class SupplyOperationImpl implements OperationService {
    private ProductDao productDao;

    public SupplyOperationImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public void calculate(FruitTransaction fruitTransaction) {
        int curAmount = productDao.getQuantityOf(fruitTransaction);
        if (curAmount < 0) {
            throw new IllegalArgumentException("Balance can`t be negative, but was: " + curAmount);
        }
        curAmount = curAmount + fruitTransaction.getQuantity();
        productDao.update(fruitTransaction, curAmount);
    }
}
