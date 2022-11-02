package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;

public class SupplyOperation implements OperationHandler {
    private final FruitDao storageDao;

    public SupplyOperation(FruitDao fruitDao) {
        this.storageDao = fruitDao;
    }

    @Override
    public void doCalculation(FruitTransaction fruitTransaction) {
        Integer currentQuantity = storageDao.getQuantity(fruitTransaction.getFruit());
        storageDao.add(fruitTransaction.getFruit().getType(),
                currentQuantity + fruitTransaction.getQuantity());
    }
}
