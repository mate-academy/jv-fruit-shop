package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.Transaction;
import core.basesyntax.strategy.OperationHandler;

public class ReturnHandlerImpl implements OperationHandler {
    private final FruitDao fruitDao = new FruitDaoImpl();

    @Override
    public void applyChanges(Transaction transaction) {
        if (fruitDao.get(transaction.getFruit()) == null) {
            throw new RuntimeException("We don't have fruits for return - "
                    + transaction.getFruit());
        }
        fruitDao.add(transaction.getFruit(),
                fruitDao.get(transaction.getFruit())
                        + transaction.getAmountFruits());
    }
}
