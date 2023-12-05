package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class FruitsBalancer implements OperationHandler {
    private FruitStorageDao fruitStorageDao;

    public FruitsBalancer(FruitStorageDao fruitStorageDao) {
        this.fruitStorageDao = fruitStorageDao;
    }

    @Override
    public void executeOperation(FruitTransaction fruitTransaction) {
        fruitStorageDao.updateFruitQuantity(fruitTransaction.getFruit(),
                fruitTransaction.getQuantity());
    }
}
