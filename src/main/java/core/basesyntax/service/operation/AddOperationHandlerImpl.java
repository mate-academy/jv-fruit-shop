package core.basesyntax.service.operation;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.Fruit;

public class AddOperationHandlerImpl implements OperationHandler {
    private final StorageDao fruitStorageDao;

    public AddOperationHandlerImpl(StorageDao fruitStorageDao) {
        this.fruitStorageDao = fruitStorageDao;
    }

    @Override
    public void apply(Fruit fruit, int quantity) {
        if (fruitStorageDao.containsKey(fruit)) {
            fruitStorageDao.supply(fruit, quantity);
        } else {
            fruitStorageDao.add(fruit, quantity);
        }
    }
}
