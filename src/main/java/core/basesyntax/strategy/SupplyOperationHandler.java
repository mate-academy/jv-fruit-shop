package core.basesyntax.strategy;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.FruitTransaction;

public class SupplyOperationHandler implements OperationHandler {

    private final StorageDao storageDao;

    public SupplyOperationHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void handle(FruitTransaction transaction) {

        Integer currentQuantity = storageDao.get(transaction);
        int newQuantity = currentQuantity + transaction.getQuantity();
        transaction.setQuantity(newQuantity);
        storageDao.add(transaction);
    }
}
