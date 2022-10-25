package core.basesyntax.strategy.transactions;

import core.basesyntax.db.StorageDao;

public interface TransactionProducer {
    void transactionProduce(FruitTransaction fruitTransaction,
                              StorageDao storageDao);
}
