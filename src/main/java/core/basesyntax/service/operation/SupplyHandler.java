package core.basesyntax.service.operation;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.FruitTransaction;

public class SupplyHandler implements OperationHandler {
    private final StorageDao storageDao;

    public SupplyHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void putTransaction(FruitTransaction record) {
        if (record.getQuantity() < 0) {
            throw new RuntimeException("Wrong " + record.getFruit()
                    + " quantity "
                    + record.getQuantity());
        }
        if (storageDao.getStorage().containsKey(record.getFruit())) {
            int value = record.getQuantity() + storageDao.getFruitAmount(record.getFruit());
            storageDao.putFruit(record.getFruit(), value);
        } else {
            storageDao.putFruit(record.getFruit(), record.getQuantity());
        }
    }
}
