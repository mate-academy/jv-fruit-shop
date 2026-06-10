package core.basesyntax.handler;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.FruitTransaction;

public class ReturnOperationHandler implements OperationHandler {
    private final StorageDao storageDao;

    public ReturnOperationHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void applyOperation(FruitTransaction transaction) {
        if (transaction == null) {
            throw new NullPointerException("Transaction is null");
        }
        Integer previousValue = storageDao.get(transaction.getFruit());
        storageDao.set(transaction.getFruit(), previousValue != null
                ? previousValue + transaction.getQuantity()
                : transaction.getQuantity());
    }
}
