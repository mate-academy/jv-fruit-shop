package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitStockDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseOperationHandlerImpl implements OperationHandler {
    private final FruitStockDao fruitTransactionDao;

    public PurchaseOperationHandlerImpl(FruitStockDao fruitTransactionDao) {
        this.fruitTransactionDao = fruitTransactionDao;
    }

    @Override
    public void operate(FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        int quantityUpdated = fruitTransactionDao.get(fruit);
        if (fruitTransaction.getQuantity() > quantityUpdated) {
            throw new RuntimeException("Quantity of " + fruit + "in stock is " + quantityUpdated
                    + ", less than quantity expected to be purchased "
                    + fruitTransaction.getQuantity());
        }
        quantityUpdated -= fruitTransaction.getQuantity();
        fruitTransactionDao.put(fruit, quantityUpdated);
    }
}
