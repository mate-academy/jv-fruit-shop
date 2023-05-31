package core.basesyntax.strategy.impl;

import core.basesyntax.exception.NotEnoughProductsException;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ProductDao;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    private ProductDao productDao;

    public PurchaseOperationHandler(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        int currentAmount = productDao.getQuantityOf(fruitTransaction);
        if (currentAmount < fruitTransaction.getQuantity()) {
            throw new NotEnoughProductsException("not enough product: "
                    + fruitTransaction.getFruit()
                    + ", in stock now: "
                    + currentAmount
                    + ", but your order: " + fruitTransaction.getQuantity());
        }
        currentAmount -= fruitTransaction.getQuantity();
        productDao.update(fruitTransaction, currentAmount);
    }
}
