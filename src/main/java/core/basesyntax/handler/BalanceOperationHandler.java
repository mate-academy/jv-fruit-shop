package core.basesyntax.handler;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.impl.StorageDaoImpl;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperationHandler implements OperationHandler {
    private StorageDao storageDao = new StorageDaoImpl();

    @Override
    public void apply(FruitTransaction transaction) {
        storageDao.add(transaction.getFruit(),transaction.getQuantity());
    }
}
