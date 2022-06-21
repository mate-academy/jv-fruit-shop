package core.basesyntax.service.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;

public class ReturnHandler implements OperationHandler {
    @Override
    public void toProcess(FruitTransaction fruitTransaction) {
        StorageDao storageDao = new StorageDaoImpl();
        storageDao.create(
                fruitTransaction.getFruit(),
                storageDao.get(fruitTransaction.getFruit())
                        + fruitTransaction.getQuantity());
    }
}
