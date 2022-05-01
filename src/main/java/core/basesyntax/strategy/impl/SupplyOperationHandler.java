package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.storage.StorageDao;
import core.basesyntax.storage.StorageDaoImpl;

public class SupplyOperationHandler implements OperationHandler {
    private final StorageDao storageDao;

    public SupplyOperationHandler() {
        storageDao = new StorageDaoImpl();
    }

    @Override
    public void handle(FruitTransaction transaction) {
        int currentQuantity = storageDao.getAmount(transaction.getFruit());
        int newQuantity = currentQuantity + transaction.getQuantity();
        storageDao.update(transaction.getFruit(), newQuantity);
    }
}
