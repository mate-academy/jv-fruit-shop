package core.basesyntax.strategy;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperationService implements OperationService {
    private StorageDao storageDao;

    public PurchaseOperationService(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void process(FruitTransaction fruitTransaction) {
        if (storageDao.get(
                fruitTransaction.getFruit()) < fruitTransaction.getQuantity()) {
            throw new RuntimeException("Not enough fruits in storage");
        }
        storageDao.remove(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
