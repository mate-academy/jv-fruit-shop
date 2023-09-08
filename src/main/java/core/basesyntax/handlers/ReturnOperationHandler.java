package core.basesyntax.handlers;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.Fruit;

public class ReturnOperationHandler implements OperationHandler {
    private StorageDao storageDao;

    public ReturnOperationHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void doOperation(Fruit fruit, Integer quantity) {
        Integer initialQuantity = storageDao.get(fruit);
        storageDao.add(fruit, quantity + (initialQuantity == null ? 0 : initialQuantity));
    }
}
