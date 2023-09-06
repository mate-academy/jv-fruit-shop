package core.basesyntax.service.operation;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.FruitTransaction;

public class ReturnHandler implements OperationHandler {
    private final StorageDao storageDao;

    public ReturnHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void processTransaction(FruitTransaction record) {
        int value = record.getQuantity() + storageDao.getFruitAmount(record.getFruit());
        storageDao.putFruit(record.getFruit(), value);
    }
}
