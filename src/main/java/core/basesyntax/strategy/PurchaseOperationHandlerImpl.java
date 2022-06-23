package core.basesyntax.strategy;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperationHandlerImpl implements OperationHandler {
    private final StorageDao storageDao;

    public PurchaseOperationHandlerImpl(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void changeQuantity(FruitTransaction fruitTransaction) {
        if (fruitTransaction.getQuantity()
                > storageDao.getRemainFruit(fruitTransaction.getFruit())) {
            throw new RuntimeException(
                    fruitTransaction.getFruit() + " cannot be purchase. They aren`t enough.");
        }
        storageDao.updateData(fruitTransaction.getFruit(),
                storageDao.getRemainFruit(fruitTransaction.getFruit())
                        - fruitTransaction.getQuantity());
    }
}
