package core.basesyntax.handlers;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.Fruit;

public class PurchaseOperationHandler implements OperationHandler {
    private StorageDao storageDao;

    public PurchaseOperationHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void doOperation(Fruit fruit, Integer quantity) {
        Integer initialQuantity = storageDao.get(fruit);
        if (initialQuantity == null || initialQuantity < quantity) {
            throw new RuntimeException("Not enough fruit. You need "
                    + quantity + " fruits, but there are " + initialQuantity + " the store");
        }
        storageDao.add(fruit, initialQuantity - quantity);
    }
}
