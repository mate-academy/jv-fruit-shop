package operation;

import dao.StorageDao;
import model.Fruit;

public class PurchaseOperationHandler implements OperationHandler {
    private StorageDao storageDao;

    public PurchaseOperationHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void apply(Fruit fruit, int quantity) {
        int quantityFromDB = storageDao.get(fruit);
        if (quantity > quantityFromDB) {
            throw new RuntimeException("Shop don't have enough fruit, please peek less than "
                    + quantityFromDB);
        }
        storageDao.add(fruit, storageDao.get(fruit) - quantity);
    }
}
