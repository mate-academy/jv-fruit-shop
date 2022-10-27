package core.basesyntax.strategy.transactions.impl;

import core.basesyntax.db.StorageDao;
import core.basesyntax.strategy.transactions.FruitTransaction;
import core.basesyntax.strategy.transactions.TransactionProducer;

public class ReduceProducer implements TransactionProducer {
    private final StorageDao storageDao;

    public ReduceProducer(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void produceTransaction(FruitTransaction fruitTransaction) {
        Integer oldValue = storageDao.getValue(fruitTransaction.getFruitName());
        Integer newValue = oldValue - fruitTransaction.getValueOfFruit();
        storageDao.setValue(fruitTransaction.getFruitName(),
                newValue);
    }
}
