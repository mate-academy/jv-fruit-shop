package core.basesyntax.services.operation;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.db.Storage;
import core.basesyntax.exceptions.OperationException;

public class PurchaseOperationHandlerImpl implements OperationHandler {
    private final FruitStorageDao fruitStorageDao;

    public PurchaseOperationHandlerImpl(FruitStorageDao fruitStorageDao) {
        this.fruitStorageDao = fruitStorageDao;
    }

    @Override
    public void apply(String fruitName, int quantity) {
        if (Storage.storage.get(fruitName) == null) {
            fruitStorageDao.add(fruitName, quantity);
        }
        if (Storage.storage.get(fruitName) != null
                && Storage.storage.get(fruitName) - quantity < 0) {
            throw new OperationException("Can not overgo zero balance"
                    + ", please check the quantity");
        }
        fruitStorageDao.update(fruitName, quantity);
    }
}
