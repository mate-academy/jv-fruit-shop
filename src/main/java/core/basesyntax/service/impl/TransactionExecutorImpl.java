package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionExecutor;
import core.basesyntax.service.TransactionStrategy;
import java.util.List;
import java.util.Map;

public class TransactionExecutorImpl implements TransactionExecutor {
    @Override
    public Map<String, Integer> executeAll(List<FruitTransaction> fruitTransactions) {
        TransactionStrategy transactionStrategy = new TransactionStrategyImpl();
        Map<String, Integer> fruits = Storage.getFruits();
        for (FruitTransaction fruit : fruitTransactions) {
            transactionStrategy.getHandler(fruit).makeTransaction(fruit);
        }
        return fruits;
    }
}


