package core.basesyntax.strategy;

import core.basesyntax.dao.ProductDao;
import core.basesyntax.model.FruitTransaction;

public class SupplyOperationHandler implements OperationHandler {
    private final ProductDao productDao;

    public SupplyOperationHandler(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public void operationByTransaction(FruitTransaction fruitTransaction) {
        int totalQuantity = productDao.getQuantity(fruitTransaction)
                + fruitTransaction.getQuantity();
        if (totalQuantity < 0) {
            throw new IllegalArgumentException(
                    "Balance can`t be negative, but was: " + totalQuantity);
        }
        productDao.update(fruitTransaction, totalQuantity);
    }
}
