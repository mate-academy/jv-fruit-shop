package core.basesyntax.service.operation;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.db.Storage;
import core.basesyntax.exception.OperationException;

public class PurchaseOperationHandlerImpl implements OperationHandler {
    private final StorageDao fruitStorageDao;

    public PurchaseOperationHandlerImpl(StorageDao fruitStorageDao) {
        this.fruitStorageDao = fruitStorageDao;
    }

    @Override
    public void apply(String fruitName, int quantity) {
        if (Storage.storage.get(fruitName) - quantity < 0) {
            throw new OperationException("There are no products to purchase");
        }
        fruitStorageDao.update(fruitName, quantity);
    }
}
