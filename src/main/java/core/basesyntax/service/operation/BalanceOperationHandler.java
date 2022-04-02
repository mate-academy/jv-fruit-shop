package core.basesyntax.service.operation;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.Fruit;

public class BalanceOperationHandler implements OperationHandler {
    private final StorageDao fruitStorageDao;

    public BalanceOperationHandler(StorageDao fruitStorageDao) {
        this.fruitStorageDao = fruitStorageDao;
    }

    @Override
    public void apply(Fruit fruit, int quantity) {
        fruitStorageDao.add(fruit, quantity);
    }
}
