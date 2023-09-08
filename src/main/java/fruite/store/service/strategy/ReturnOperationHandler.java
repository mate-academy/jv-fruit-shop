package fruite.store.service.strategy;

import fruite.store.dao.StorageDao;
import fruite.store.dao.StorageDaoImpl;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void doOperation(String fruit, Integer quantity) {
        StorageDao storageDao = new StorageDaoImpl();
        storageDao.addValueByKey(fruit, quantity);
    }
}
