package core.basesyntax.strategy.operation;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;

public class PurchaseOperation implements OperationHandler {
    private StorageDao storageDao = new StorageDaoImpl();

    @Override
    public void operationType(String fruit, int amount) {
        int newQuantity = storageDao.getFruit(fruit).getQuantity() - amount;
        storageDao.update(fruit, newQuantity);
    }
}
