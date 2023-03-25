package core.basesyntax.service;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.TransactionStrategy;

public interface ProcessTransactionService {
    Fruit addDataIntoStorage(FruitTransaction fruitTransaction,
                             StorageDao storageDao,
                             TransactionStrategy transactionStrategy);
}
