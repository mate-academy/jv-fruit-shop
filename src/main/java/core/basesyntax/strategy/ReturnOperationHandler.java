package core.basesyntax.strategy;

import core.basesyntax.dao.ProductDao;
import core.basesyntax.model.FruitTransaction;

public class ReturnOperationHandler implements OperationHandler {
    private final ProductDao productDao;

    public ReturnOperationHandler(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public void doOperationByTransaction(FruitTransaction fruitTransaction) {
        int totalQuantity = productDao.getQuantity(fruitTransaction)
                + fruitTransaction.getQuantity();
        if (totalQuantity < 0) {
            throw new IllegalArgumentException(
                    "Balance can`t be negative, but was: " + totalQuantity);
        }
        productDao.update(fruitTransaction, totalQuantity);
    }
}
