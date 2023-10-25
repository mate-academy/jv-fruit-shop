package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class SupplyOperationHandler implements OperationHandler {
    private static final FruitDao fruitDao = new FruitDaoImpl();

    @Override
    public void getTransaction(FruitTransaction transaction) {
        fruitDao.put(transaction.getFruit(), transaction.getQuantity());
    }
}
