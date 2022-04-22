package core.basesyntax.service.strategy.handlers;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.NotEnoughFruitsInStorage;

public class PurchaseOperationHandler implements OperationHandler {
    private final StorageDao storageDao;

    public PurchaseOperationHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void doOperation(FruitTransaction fruitTransaction) {
        if (storageDao.getByKey(fruitTransaction.getFruit()) < fruitTransaction.getQuantity()) {
            throw new NotEnoughFruitsInStorage("Can't do this operation");
        }
        storageDao.addToDataBase(fruitTransaction.getFruit(),
                storageDao.getByKey(fruitTransaction.getFruit()) - fruitTransaction.getQuantity());
    }
}
