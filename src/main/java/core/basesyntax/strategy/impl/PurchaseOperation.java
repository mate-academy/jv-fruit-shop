package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperation implements OperationHandler {
    private final FruitDao storageDao;

    public PurchaseOperation() {
        this.storageDao = new FruitDaoImpl();
    }

    @Override
    public void doCalculation(FruitTransaction fruitTransaction) {
        Integer currentQuantity = storageDao.getQuantity(fruitTransaction.getFruit());
        storageDao.add(fruitTransaction.getFruit().getType(),
                currentQuantity - fruitTransaction.getQuantity());
    }
}
