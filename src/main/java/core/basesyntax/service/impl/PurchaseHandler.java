package core.basesyntax.service.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;

public class PurchaseHandler implements OperationHandler {
    private final StorageDao storageDao = new StorageDaoImpl();

    @Override
    public void handler(FruitTransaction fruitTransaction) {
        storageDao.create(
                fruitTransaction.getFruit(),
                storageDao.get(fruitTransaction.getFruit())
                        - fruitTransaction.getQuantity());
    }
}
