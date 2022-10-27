package core.basesyntax.strategy.transactions.impl;

import core.basesyntax.db.StorageDao;
import core.basesyntax.strategy.transactions.FruitTransaction;
import core.basesyntax.strategy.transactions.TransactionProducer;

public class SaverProducer implements TransactionProducer {
    private final StorageDao storageDao;

    public SaverProducer(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void produceTransaction(FruitTransaction fruitTransaction) {
        storageDao.add(fruitTransaction.getFruitName(),
                fruitTransaction.getValueOfFruit());
    }
}
