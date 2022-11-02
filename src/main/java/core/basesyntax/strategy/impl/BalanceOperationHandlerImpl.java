package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class BalanceOperationHandlerImpl implements OperationHandler {
    private FruitDao fruitDao;

    public BalanceOperationHandlerImpl() {
        this.fruitDao = new FruitDaoImpl();
    }

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        fruitDao.add(new Fruit(fruitTransaction.getFruit(), fruitTransaction.getQuantity()));
    }
}
