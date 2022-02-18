package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.dao.FruitStorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class ReturnOperationHandler implements OperationHandler {
    private FruitStorageDao fruitStorageDao = new FruitStorageDaoImpl();

    @Override
    public void operationProcess(FruitTransaction fruitTransaction) {
        int value = fruitStorageDao.get(fruitTransaction.getFruit())
                + fruitTransaction.getQuantity();
        fruitStorageDao.add(fruitTransaction.getFruit(), value);
    }
}
