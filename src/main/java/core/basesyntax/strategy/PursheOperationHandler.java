package core.basesyntax.strategy;

import core.basesyntax.dao.ProductDao;
import core.basesyntax.model.FruitTransaction;

public class PursheOperationHandler implements OperationHandler {
    private final ProductDao productDao;

    public PursheOperationHandler(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public void operationByTransaction(FruitTransaction fruitTransaction) {
        int curAmount = productDao.getQuantity(fruitTransaction);
        if (curAmount < fruitTransaction.getQuantity()) {
            throw new RuntimeException("Not enough fruits in storage");
        }
        curAmount = curAmount - fruitTransaction.getQuantity();
        productDao.update(fruitTransaction, curAmount);
    }
}
