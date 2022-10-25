package core.basesyntax.strategy.transactions.impl;

import core.basesyntax.db.StorageDao;
import core.basesyntax.strategy.transactions.FruitTransaction;
import core.basesyntax.strategy.transactions.TransactionProducer;

public class SaverProducer implements TransactionProducer {
    @Override
    public void transactionProduce(FruitTransaction fruitTransaction,
                                     StorageDao storageDao) {
        storageDao.add(fruitTransaction.getFruitName(),
                fruitTransaction.getValueOfFruit());
    }
}
