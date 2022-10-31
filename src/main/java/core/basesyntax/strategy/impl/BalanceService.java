package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;

public class BalanceService implements OperationHandler {
    private final FruitDao fruitDao = new FruitDaoImpl();

    @Override
    public void operationWithFruitTransaction(FruitTransaction fruitTransaction) {
        fruitDao.add(new Fruit(fruitTransaction.getFruit(), fruitTransaction.getQuantity()));
    }
}
