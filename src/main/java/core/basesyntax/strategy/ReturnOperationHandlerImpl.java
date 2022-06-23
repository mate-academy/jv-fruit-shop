package core.basesyntax.strategy;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.FruitTransaction;

public class ReturnOperationHandlerImpl implements OperationHandler {
    private final StorageDao storageDao;

    public ReturnOperationHandlerImpl(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void changeQuantity(FruitTransaction fruitTransaction) {
        storageDao.updateData(fruitTransaction.getFruit(),
                storageDao.getRemainFruit(fruitTransaction.getFruit())
                        + fruitTransaction.getQuantity());
    }
}
