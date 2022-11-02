package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class BalanceOperationStrategy implements OperationHandler {
    private FruitDao fruitDao = new FruitDaoImpl();

    @Override
    public void processFruitTransactionOperation(FruitTransaction fruitTransaction) {
        fruitDao.putFruit(fruitTransaction);
    }
}
