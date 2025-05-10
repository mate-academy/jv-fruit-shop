package core.basesyntax.service.impl.operation;

import core.basesyntax.dao.FruitStorageDao;

public class BalanceOperation implements OperationHandler {
    private final FruitStorageDao storageDao;

    public BalanceOperation(FruitStorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void doOperation(String fruitName, Integer quantity) {
        storageDao.setQuantity(fruitName, quantity);
    }
}
