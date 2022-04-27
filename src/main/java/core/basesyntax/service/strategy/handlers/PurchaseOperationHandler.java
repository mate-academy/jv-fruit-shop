package core.basesyntax.service.strategy.handlers;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.exeption.NotEnoughFruitsInStorage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperationHandler implements OperationHandler {
    private final StorageDao storageDao;

    public PurchaseOperationHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void doOperation(FruitTransaction fruitTransaction) {
        Integer existingFruitQuantity = storageDao.get(fruitTransaction.getFruit());
        if (existingFruitQuantity < fruitTransaction.getQuantity()) {
            throw new NotEnoughFruitsInStorage("Can't do this operation");
        }
        storageDao.add(fruitTransaction.getFruit(),
                existingFruitQuantity - fruitTransaction.getQuantity());
    }
}
