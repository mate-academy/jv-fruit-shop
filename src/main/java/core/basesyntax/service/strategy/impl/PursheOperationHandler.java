package core.basesyntax.service.strategy.impl;

import core.basesyntax.dao.ProductDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.strategy.OperationHandler;

public class PursheOperationHandler implements OperationHandler {
    private final ProductDao productDao;

    public PursheOperationHandler(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        int curAmount = productDao.getQuantity(fruitTransaction);
        if (curAmount < fruitTransaction.getQuantity()) {
            throw new RuntimeException("Not enough fruits in storage");
        }
        curAmount = curAmount - fruitTransaction.getQuantity();
        productDao.update(fruitTransaction, curAmount);
    }
}
