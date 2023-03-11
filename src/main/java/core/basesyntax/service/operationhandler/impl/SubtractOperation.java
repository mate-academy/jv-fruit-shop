package core.basesyntax.service.operationhandler.impl;

import core.basesyntax.bd.dao.StorageDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.operationhandler.OperationHandler;

public class SubtractOperation implements OperationHandler {
    private StorageDao storageDao;

    public SubtractOperation(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public boolean apply(Transaction transaction) {
        Fruit fruit = transaction.getFruit();
        Integer quantity = transaction.getQuantity();
        if (!storageDao.isFruitPresent(fruit)) {
            throw new RuntimeException("There are no fruits to subtract");
        } else if ((storageDao.getFruitQuantity(fruit) - quantity) < 0) {
            throw new RuntimeException("Fruit quantity can`t be negative");
        } else {
            quantity = storageDao.getFruitQuantity(fruit) - quantity;
            storageDao.add(fruit, quantity);
        }
        return true;
    }
}
