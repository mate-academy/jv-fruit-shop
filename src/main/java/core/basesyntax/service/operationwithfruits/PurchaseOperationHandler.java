package core.basesyntax.service.operationwithfruits;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.service.FruitTransaction;

public class PurchaseOperationHandler implements OperationHandler {
    private final StorageDao storageDao;

    public PurchaseOperationHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void getOperation(FruitTransaction transaction) {
        storageDao.update(transaction.getFruit(),
                storageDao.getCountFruit(transaction.getFruit())
                        - transaction.getQuantity());
    }
}
