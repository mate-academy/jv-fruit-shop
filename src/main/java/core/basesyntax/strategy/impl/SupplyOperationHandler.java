package core.basesyntax.strategy.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class SupplyOperationHandler implements OperationHandler {
    private final StorageDao storageDao;

    public SupplyOperationHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void handle(FruitTransaction transaction) {
        int currentQuantity = storageDao.getAmountByProductName(transaction.fruit());
        storageDao.putProduct(
                transaction.fruit(),
                currentQuantity + transaction.quantity()
        );
    }
}
