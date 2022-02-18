package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.dao.FruitStorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {
    private FruitStorageDao fruitStorageDao = new FruitStorageDaoImpl();

    @Override
    public void operationProcess(FruitTransaction fruitTransaction) {
        fruitStorageDao.add(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
