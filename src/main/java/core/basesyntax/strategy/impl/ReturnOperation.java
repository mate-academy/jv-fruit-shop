package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;

public class ReturnOperation implements OperationHandler {
    private final FruitDao storageDao = new FruitDaoImpl();

    @Override
    public void doCalculation(FruitTransaction fruitTransaction) {
        Integer currentQuantity = storageDao.getValue(fruitTransaction.getFruit());
        storageDao.putValue(fruitTransaction.getFruit().getType(),
                currentQuantity + fruitTransaction.getQuantity());
    }
}
