package service;

import db.FruitStorage;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import strategy.TransactionStrategy;
import util.StrategyException;

public class FruitStoreServiceImpl implements FruitStoreService {
    private Map<FruitTransaction.Operation, TransactionStrategy> strategyMap;

    public FruitStoreServiceImpl(Map<FruitTransaction.Operation, TransactionStrategy> strategyMap) {
        this.strategyMap = strategyMap;
    }

    @Override
    public FruitStorage processTransactions(List<FruitTransaction> transactions) {
        FruitStorage fruitStorage = new FruitStorage();
        for (FruitTransaction transaction : transactions) {
            TransactionStrategy strategy = strategyMap.get(transaction.getOperation());
            if (strategy != null) {
                strategy.apply(fruitStorage, transaction);
            } else {
                throw new StrategyException(
                        "Strategy not found for operation: " + transaction.getOperation());
            }
        }

        return fruitStorage;
    }
}
