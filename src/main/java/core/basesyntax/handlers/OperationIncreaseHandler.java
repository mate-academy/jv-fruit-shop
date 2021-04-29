package core.basesyntax.handlers;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.product.Fruit;

public class OperationIncreaseHandler implements OperationHandler {
    private final StorageDao storageDao;

    public OperationIncreaseHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public int apply(Fruit fruit, int amount) {
        int amountFromStorage = storageDao.get(fruit).orElse(0);
        int newAmount = amountFromStorage + amount;
        storageDao.add(fruit, newAmount);
        return newAmount;
    }
}
