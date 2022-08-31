package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class FruitPurchaseHandler implements OperationHandler {
    private final FruitDao fruitDao;

    public FruitPurchaseHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void proceed(FruitTransaction fruitTransaction) {
        fruitDao.subtract(fruitTransaction.getFruit(),
                fruitTransaction.getQuantity());
    }
}
