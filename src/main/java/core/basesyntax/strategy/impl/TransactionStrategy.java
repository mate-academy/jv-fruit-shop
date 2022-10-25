package core.basesyntax.strategy.impl;

import core.basesyntax.db.StorageDao;
import core.basesyntax.strategy.Operation;
import core.basesyntax.strategy.TransactionProcessor;
import core.basesyntax.strategy.transactions.FruitTransaction;
import core.basesyntax.strategy.transactions.TransactionProducer;
import java.util.HashMap;
import java.util.List;

public class TransactionStrategy implements TransactionProcessor {
    private final StorageDao storageDao;
    private final HashMap<Operation, TransactionProducer> transactionMap;

    public TransactionStrategy(StorageDao storageDao,
                               HashMap<Operation, TransactionProducer> transactionMap) {
        this.storageDao = storageDao;
        this.transactionMap = transactionMap;
    }

    public void processTransactions(List<String> actions) {
        actions.forEach(s -> transactionStrategy(new FruitTransaction(s)));
    }

    private void transactionStrategy(FruitTransaction fruitTransaction) {
        transactionMap.get(fruitTransaction.getOperation())
                .transactionProduce(fruitTransaction, storageDao);
    }
}
