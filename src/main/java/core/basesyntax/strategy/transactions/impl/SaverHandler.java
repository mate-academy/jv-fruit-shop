package core.basesyntax.strategy.transactions.impl;

import core.basesyntax.db.StorageDao;
import core.basesyntax.strategy.transactions.FruitTransaction;
import core.basesyntax.strategy.transactions.TransactionHandler;

public class SaverHandler implements TransactionHandler {
    private final StorageDao storageDao;

    public SaverHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void apply(FruitTransaction fruitTransaction) {
        storageDao.add(fruitTransaction.getFruitName(),
                fruitTransaction.getValueOfFruit());
    }
}
