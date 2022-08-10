package core.basesyntax.service.operation.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.operation.OperationHandler;

public class BalanceHandler implements OperationHandler {
    private final StorageDao storageDao;

    public BalanceHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void operation(Transaction transaction) {
        storageDao.addFruit(new Fruit(transaction.getFruit().getName(),
                transaction.getFruit().getAmountFruit()));
    }
}
