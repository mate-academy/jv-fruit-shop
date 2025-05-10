package core.basesyntax.service.operation;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperationHandler implements OperationHandler {
    private StorageDao storageDao;

    public BalanceOperationHandler() {
        storageDao = new StorageDaoImpl();
    }

    @Override
    public void performOperation(FruitTransaction transaction) {
        storageDao.save(transaction.getFruit(), transaction.getQuantity());
    }
}
