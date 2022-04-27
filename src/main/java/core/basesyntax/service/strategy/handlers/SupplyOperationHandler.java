package core.basesyntax.service.strategy.handlers;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.FruitTransaction;

public class SupplyOperationHandler implements OperationHandler {
    private final StorageDao storageDao;

    public SupplyOperationHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void doOperation(FruitTransaction fruitTransaction) {
        storageDao.add(fruitTransaction.getFruit(),
                storageDao.get(fruitTransaction.getFruit())
                        + fruitTransaction.getQuantity());
    }
}
