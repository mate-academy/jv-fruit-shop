package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.Transaction;
import core.basesyntax.strategy.OperationHandler;

public class BalanceHandlerImpl implements OperationHandler {
    private final FruitDao fruitDao = new FruitDaoImpl();

    @Override
    public void applyChanges(Transaction transaction) {
        fruitDao.add(transaction.getFruit(), transaction.getAmountFruits());
    }
}
