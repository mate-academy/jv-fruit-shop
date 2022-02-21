package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    private final FruitDao fruitDao = new FruitDaoImpl();

    @Override
    public void operationProcess(FruitTransaction fruitTransaction) {
        int value = fruitDao.get(fruitTransaction.getFruit())
                - fruitTransaction.getQuantity();
        if (value < 0) {
            throw new RuntimeException("You don't have enough " + fruitTransaction.getFruit());
        }
        fruitDao.add(fruitTransaction.getFruit(), value);
    }
}
