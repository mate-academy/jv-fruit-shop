package core.basesyntax.service.strategy;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.FruitTransaction;

public class PurchaseHandler implements OperationHandler {

    private final StorageDao storageDao;

    public PurchaseHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public Integer processTransaction(FruitTransaction transaction) {
        int balance = 0;
        if (storageDao.getAmount(transaction.getFruit()) != null) {
            balance = storageDao.getAmount(transaction.getFruit());
        }
        return balance -= transaction.getQuantity();
    }
}
