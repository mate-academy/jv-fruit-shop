package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitStockDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;
import java.util.AbstractMap;

public class PurchaseOperationHandlerImpl implements OperationHandler {
    private final FruitStockDao fruitTransactionDao;

    public PurchaseOperationHandlerImpl(FruitStockDao fruitTransactionDao) {
        this.fruitTransactionDao = fruitTransactionDao;
    }

    @Override
    public void operate(FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        int quantityUpdated = fruitTransactionDao.get(fruit).getValue();
        quantityUpdated -= fruitTransaction.getQuantity();
        fruitTransactionDao.update(new AbstractMap.SimpleEntry<>(fruit,quantityUpdated));
    }
}
