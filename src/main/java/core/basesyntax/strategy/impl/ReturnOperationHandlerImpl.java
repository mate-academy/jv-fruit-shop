package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitStockDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class ReturnOperationHandlerImpl implements OperationHandler {
    private final FruitStockDao fruitTransactionDao;

    public ReturnOperationHandlerImpl(FruitStockDao fruitTransactionDao) {
        this.fruitTransactionDao = fruitTransactionDao;
    }

    @Override
    public void operate(FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        int quantityUpdated = fruitTransactionDao.get(fruit);
        quantityUpdated += fruitTransaction.getQuantity();
        fruitTransactionDao.put(fruit, quantityUpdated);
    }
}
