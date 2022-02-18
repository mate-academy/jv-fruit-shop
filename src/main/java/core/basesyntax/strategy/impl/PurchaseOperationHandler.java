package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.dao.FruitStorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    private FruitStorageDao fruitStorageDao = new FruitStorageDaoImpl();

    @Override
    public void operationProcess(FruitTransaction fruitTransaction) {
        int value = fruitStorageDao.get(fruitTransaction.getFruit())
                - fruitTransaction.getQuantity();
        if (value < 0) {
            throw new RuntimeException("You don't have enough " + fruitTransaction.getFruit());
        }
        fruitStorageDao.add(fruitTransaction.getFruit(), value);
    }
}
