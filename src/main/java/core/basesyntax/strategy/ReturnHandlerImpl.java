package core.basesyntax.strategy;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.storage.Storage;

public class ReturnHandlerImpl implements OperationHandler {
    private final StorageDao fruitStorageDao;

    public ReturnHandlerImpl(StorageDao fruitStorageDao) {
        this.fruitStorageDao = fruitStorageDao;
    }

    @Override
    public void apply(Fruit fruit, int quantity) {
        if (!Storage.storage.containsKey(fruit)) {
            fruitStorageDao.add(fruit, quantity);
        } else {
            fruitStorageDao.supply(fruit, quantity);
        }
    }
}
