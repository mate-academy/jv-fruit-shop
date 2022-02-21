package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class QuantityAddOperationHandler implements OperationHandler {
    private final FruitDao fruitDao = new FruitDaoImpl();

    @Override
    public void operationProcess(FruitTransaction fruitTransaction) {
        if (fruitDao.get(fruitTransaction.getFruit()) != null) {
            int value = fruitDao.get(fruitTransaction.getFruit())
                    + fruitTransaction.getQuantity();
            fruitDao.add(fruitTransaction.getFruit(), value);
        } else {
            fruitDao.add(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
        }
    }
}
