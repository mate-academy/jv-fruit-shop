package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {
    private FruitDao fruitDao;

    {
        fruitDao = new FruitDaoImpl();
    }

    @Override
    public void handle(FruitTransaction transaction) {
        fruitDao.updateData(transaction.getFruit(), transaction.getQuantity());
    }
}
