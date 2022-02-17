package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.dao.FruitStorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationProcess;

public class PurchaseOperationProcess implements OperationProcess {
    private FruitStorageDao fruitStorageDao = new FruitStorageDaoImpl();

    @Override
    public void operationProcess(FruitTransaction fruitTransaction) {
        int value;
        try {
            value = fruitStorageDao.get(fruitTransaction.getFruit())
                    - fruitTransaction.getQuantity();
        } catch (RuntimeException ex) {
            value = fruitTransaction.getQuantity();
        }
        fruitStorageDao.add(fruitTransaction.getFruit(), value);
    }
}
