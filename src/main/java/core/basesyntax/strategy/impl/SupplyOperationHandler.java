package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class SupplyOperationHandler implements OperationHandler {
    private FruitDao fruitDao = new FruitDaoImpl();

    @Override
    public void operationProcess(FruitTransaction fruitTransaction) {
        int value = fruitDao.get(fruitTransaction.getFruit())
                + fruitTransaction.getQuantity();
        fruitDao.add(fruitTransaction.getFruit(), value);
    }
}
