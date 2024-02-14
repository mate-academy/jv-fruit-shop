package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.dao.impl.FruitsDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionExecutor;
import core.basesyntax.strategy.TransactionStrategy;
import core.basesyntax.strategy.impl.TransactionStrategyImpl;
import java.util.List;
import java.util.Map;

public class TransactionExecutorImpl implements TransactionExecutor {
    @Override
    public Map<String, Integer> executeAll(List<FruitTransaction> fruitTransactions) {
        FruitsDao fruitsDao = new FruitsDaoImpl();
        TransactionStrategy transactionStrategy = new TransactionStrategyImpl();
        Map<String, Integer> fruits = fruitsDao.storageAccess();
        for (FruitTransaction fruit : fruitTransactions) {
            transactionStrategy.getHandler(fruit).makeTransaction(fruit);
        }
        return fruits;
    }
}


