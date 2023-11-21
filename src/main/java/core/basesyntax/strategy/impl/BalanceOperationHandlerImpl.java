package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitStockDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;
import java.util.AbstractMap;

public class BalanceOperationHandlerImpl implements OperationHandler {

    private final FruitStockDao fruitTransactionDao;

    public BalanceOperationHandlerImpl(FruitStockDao fruitTransactionDao) {
        this.fruitTransactionDao = fruitTransactionDao;
    }

    @Override
    public void operate(FruitTransaction fruitTransaction) {
        fruitTransactionDao.add(new AbstractMap.SimpleEntry<>(fruitTransaction.getFruit(),
                fruitTransaction.getQuantity()));
    }
}
