package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperation implements OperationHandler {
    private final FruitDao storageDao = new FruitDaoImpl();

    @Override
    public void doCalculation(FruitTransaction fruitTransaction) {
        storageDao.putValue(fruitTransaction.getFruit().getType(), fruitTransaction.getQuantity());
    }
}
