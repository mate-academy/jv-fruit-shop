package operation;

import dao.StorageDao;
import model.Fruit;

public class ReturnOperationHandler implements OperationHandler {
    private StorageDao storageDao;

    public ReturnOperationHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void apply(Fruit fruit, int quantity) {
        storageDao.add(fruit, storageDao.get(fruit) + quantity);
    }
}
