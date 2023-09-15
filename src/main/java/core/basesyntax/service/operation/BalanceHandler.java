package core.basesyntax.service.operation;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.FruitTransaction;

public class BalanceHandler implements OperationHandler {
    private final StorageDao storageDao;

    public BalanceHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void putTransaction(FruitTransaction record) {
        if (record.getQuantity() < 0) {
            throw new RuntimeException("Wrong " + record.getFruit()
                    + " quantity "
                    + record.getQuantity());
        }
        storageDao.putFruit(record.getFruit(), record.getQuantity());
    }
}
