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
        if (transaction.getQuantity() > storageDao.getCountFruit(transaction.getFruit())) {
            throw new RuntimeException("The quantity exceeds its availability for "
                    + transaction.getFruit());
        }
        storageDao.update(transaction.getFruit(),
                storageDao.getCountFruit(transaction.getFruit())
                        - transaction.getQuantity());
    }
}
