package core.basesyntax.strategy.impl;

import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.StrategyOperation;

public class SupplyOperationImpl implements StrategyOperation {

    private StorageDaoImpl storageDao = new StorageDaoImpl();

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        storageDao.increaseFruitQuantity(fruitTransaction.getFruit(),
                fruitTransaction.getQuantity());
    }
}
