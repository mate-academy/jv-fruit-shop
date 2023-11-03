package core.basesyntax.strategy.handlers;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.FruitTransaction;

public class ReturnOperationHandler implements OperationHandler {
    private final StorageDao storageDao;

    public ReturnOperationHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        int quantity = fruitTransaction.getQuantity();
        int currentBalance = storageDao.getQuantityByObjectType(fruit);
        int newBalance = currentBalance + quantity;
        storageDao.putToStorage(fruit, newBalance);
    }
}
