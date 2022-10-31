package core.basesyntax.strategy.handler;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.FruitTransaction;

public class SupplyOperationHandler implements OperationHandler {
    private final StorageDao storageDao;

    public SupplyOperationHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public int execute(FruitTransaction transaction) {
        return storageDao.update(transaction.getFruit(), transaction.getQuantity());
    }
}
