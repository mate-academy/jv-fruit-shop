package core.basesyntax.strategy;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.Fruit;

public class BalanceHandler implements OperationHandler {
    private final StorageDao fruitStorageDao;

    public BalanceHandler(StorageDao fruitStorageDao) {
        this.fruitStorageDao = fruitStorageDao;
    }

    @Override
    public void apply(Fruit fruit, int quantity) {
        fruitStorageDao.add(fruit, quantity);
    }
}
