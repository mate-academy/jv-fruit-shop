package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.storage.StorageDao;

public class SupplyOperationHandler implements OperationHandler {
    private final StorageDao storageDao;

    public SupplyOperationHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void handle(FruitTransaction transaction) {
        int currentQuantity = storageDao.getAmount(transaction.getFruit());
        int newQuantity = currentQuantity + transaction.getQuantity();
        storageDao.update(transaction.getFruit(), newQuantity);
    }
}
