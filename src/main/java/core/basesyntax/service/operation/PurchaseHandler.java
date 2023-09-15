package core.basesyntax.service.operation;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.FruitTransaction;
import java.util.NoSuchElementException;

public class PurchaseHandler implements OperationHandler {
    private final StorageDao storageDao;

    public PurchaseHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void putTransaction(FruitTransaction record) {
        if (record.getQuantity() < 0) {
            throw new RuntimeException("Wrong " + record.getFruit()
                    + " quantity "
                    + record.getQuantity());
        }
        if (! storageDao.getStorage().containsKey(record.getFruit())) {
            throw new NoSuchElementException(record.getFruit() + " - not in stock");
        }

        int value = storageDao.getFruitAmount(record.getFruit()) - record.getQuantity();
        if (value < 0) {
            throw new RuntimeException("Not enough " + record.getFruit());
        }
        storageDao.putFruit(record.getFruit(), value);
    }
}
