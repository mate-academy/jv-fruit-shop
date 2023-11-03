package core.basesyntax.strategy.handlers;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperationHandler implements OperationHandler {
    private final StorageDao storageDao;

    public PurchaseOperationHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        int quantity = fruitTransaction.getQuantity();
        int currentBalance = storageDao.getQuantityByObjectType(fruit);
        int newBalance = currentBalance - quantity;
        if (newBalance < 0) {
            throw new RuntimeException("Negative balance after purchase operation");
        }
        storageDao.putToStorage(fruit, newBalance);
    }
}
