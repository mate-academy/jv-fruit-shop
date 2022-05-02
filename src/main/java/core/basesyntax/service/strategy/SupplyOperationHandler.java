package core.basesyntax.service.strategy;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.FruitTransaction;

public class SupplyOperationHandler implements OperationHandler {
    private final StorageDao storageDao;

    public SupplyOperationHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void operate(FruitTransaction transaction) {
        storageDao.compute(transaction.getFruit(), transaction.getQuantity());
    }
}
