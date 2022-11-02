package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperation implements OperationHandler {
    private final FruitDao storageDao;

    public PurchaseOperation(FruitDao fruitDao) {
        this.storageDao = fruitDao;
    }

    @Override
    public void doCalculation(FruitTransaction fruitTransaction) {
        Integer currentQuantity = storageDao.getQuantity(fruitTransaction.getFruit());
        storageDao.add(fruitTransaction.getFruit().getType(),
                currentQuantity - fruitTransaction.getQuantity());
    }
}
