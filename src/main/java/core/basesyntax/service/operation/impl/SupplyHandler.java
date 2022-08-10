package core.basesyntax.service.operation.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.operation.OperationHandler;

public class SupplyHandler implements OperationHandler {
    private final StorageDao storageDao;

    public SupplyHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void operation(Transaction transaction) {
        Integer oldAmount = storageDao.getFruit(transaction
                .getFruit()
                .getName())
                .getAmountFruit();
        storageDao.getFruit(transaction.getFruit()
                .getName())
                .setAmountFruit(oldAmount + transaction
                        .getFruit()
                        .getAmountFruit());
    }
}

