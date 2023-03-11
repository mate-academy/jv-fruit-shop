package core.basesyntax.service.operationhandler.impl;

import core.basesyntax.bd.dao.StorageDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.operationhandler.OperationHandler;

public class AddOperation implements OperationHandler {
    private StorageDao storageDao;

    public AddOperation(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public boolean apply(Transaction transaction) {
        Fruit fruit = transaction.getFruit();
        Integer quantity = transaction.getQuantity();
        if (!storageDao.isFruitPresent(fruit)) {
            storageDao.add(fruit, quantity);
        } else {
            quantity += storageDao.getFruitQuantity(fruit);
            storageDao.add(fruit, quantity);
        }
        return true;
    }
}
