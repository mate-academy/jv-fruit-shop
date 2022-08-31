package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class FruitBalanceHandler implements OperationHandler {
    private final FruitDao fruitDao;

    public FruitBalanceHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void proceed(FruitTransaction fruitTransaction) {
        fruitDao.set(fruitTransaction.getFruit(),
                fruitTransaction.getQuantity());
    }
}
