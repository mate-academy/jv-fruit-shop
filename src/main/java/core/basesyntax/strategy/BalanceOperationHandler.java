package core.basesyntax.strategy;

import core.basesyntax.dao.ProductDao;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperationHandler implements OperationHandler {
    private final ProductDao productDao;

    public BalanceOperationHandler(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public void doOperationByTransaction(FruitTransaction fruitTransaction) {
        if (fruitTransaction.getQuantity() < 0) {
            throw new RuntimeException("Balance should be positive.");
        }
        productDao.update(fruitTransaction, fruitTransaction.getQuantity());
    }
}
