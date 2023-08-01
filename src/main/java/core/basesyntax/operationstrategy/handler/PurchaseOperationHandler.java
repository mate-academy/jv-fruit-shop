package core.basesyntax.operationstrategy.handler;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void processData(String fruitName, Integer quantity) {
        StorageDao storageDao = new StorageDaoImpl();
        storageDao.take(fruitName, quantity);
    }
}
