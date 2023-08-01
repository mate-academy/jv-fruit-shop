package core.basesyntax.operationstrategy.handler;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.operationstrategy.handler.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void processData(String fruitName, Integer quantity) {
        StorageDao storageDao = new StorageDaoImpl();
        storageDao.take(fruitName, quantity);
    }
}
