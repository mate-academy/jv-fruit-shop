package core.basesyntax.strategy;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperationHandlerImpl implements OperationHandler {
    private final StorageDao storageDao;

    public PurchaseOperationHandlerImpl(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        if (fruitTransaction.getQuantity()
                > storageDao.getQuantity(fruitTransaction.getFruit())) {
            throw new RuntimeException(
                    fruitTransaction.getFruit() + " cannot be purchase. They aren`t enough.");
        }
        storageDao.update(fruitTransaction.getFruit(),
                storageDao.getQuantity(fruitTransaction.getFruit())
                        - fruitTransaction.getQuantity());
    }
}
