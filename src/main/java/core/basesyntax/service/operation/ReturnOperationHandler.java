package core.basesyntax.service.operation;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.FruitTransaction;

public class ReturnOperationHandler implements OperationHandler {
    private StorageDao storageDao;

    public ReturnOperationHandler() {
        storageDao = new StorageDaoImpl();
    }

    @Override
    public void performOperation(FruitTransaction transaction) {
        storageDao.save(transaction.getFruit(),
                storageDao.getQuantityByFruitName(transaction.getFruit())
                        + transaction.getQuantity());
    }
}
