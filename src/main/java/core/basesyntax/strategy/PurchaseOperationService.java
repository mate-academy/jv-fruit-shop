package core.basesyntax.strategy;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperationService implements OperationService {
    private StorageDao storageDao = new StorageDaoImpl();

    @Override
    public void proceed(FruitTransaction fruitTransaction) {
        if (storageDao.getFruitQuantity(
                fruitTransaction.getFruit()) < fruitTransaction.getQuantity()) {
            throw new RuntimeException("Not enough fruits in storage");
        }
        storageDao.remove(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
