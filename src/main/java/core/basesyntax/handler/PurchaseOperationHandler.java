package core.basesyntax.handler;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.impl.StorageDaoImpl;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperationHandler implements OperationHandler {
    private StorageDao storageDao = new StorageDaoImpl();

    @Override
    public void apply(FruitTransaction transaction) {
        storageDao.substractAmount(transaction.getFruit(),transaction.getQuantity());
    }
}
