package operation;

import dao.StorageDao;
import model.Fruit;

public class SupplyOperationHandler implements OperationHandler {
    private StorageDao storageDao;

    public SupplyOperationHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void apply(Fruit fruit, int quantity) {
        storageDao.add(fruit, storageDao.get(fruit) + quantity);
    }
}
