package core.basesyntax.strategy.handler;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;

public class BalanceHandlerImpl implements TransactionHandler {
    private final StorageDao storageDao;

    public BalanceHandlerImpl(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void makeTransaction(FruitTransaction transaction) {
        storageDao.update(new Fruit(transaction.getFruit()), transaction.getAmount());
    }
}
