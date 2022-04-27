package operation;

import dao.StorageDao;
import model.Fruit;

public class BalanceOperationHandler implements OperationHandler {
    private StorageDao storageDao;

    public BalanceOperationHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void apply(Fruit fruit, int quantity) {
        storageDao.add(fruit, quantity);
    }
}
