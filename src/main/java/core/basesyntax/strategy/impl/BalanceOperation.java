package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperation implements OperationHandler {
    private final FruitDao storageDao;

    public BalanceOperation(FruitDao fruitDao) {
        this.storageDao = fruitDao;
    }

    @Override
    public void doCalculation(FruitTransaction fruitTransaction) {
        storageDao.add(fruitTransaction.getFruit().getType(), fruitTransaction.getQuantity());
    }
}
