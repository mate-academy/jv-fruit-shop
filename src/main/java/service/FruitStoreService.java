package service;

import java.util.HashMap;
import java.util.Map;
import model.FruitStorage;
import model.FruitTransaction;
import model.FruitTransactionStorage;
import strategy.BalanceStrategy;
import strategy.PurchaseStrategy;
import strategy.ReturnStrategy;
import strategy.SupplyStrategy;
import strategy.TransactionStrategy;

public class FruitStoreService {
    private Map<FruitTransaction.Operation, TransactionStrategy> strategyMap;

    public FruitStoreService() {
        strategyMap = new HashMap<>();
        strategyMap.put(FruitTransaction.Operation.BALANCE, new BalanceStrategy());
        strategyMap.put(FruitTransaction.Operation.SUPPLY, new SupplyStrategy());
        strategyMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseStrategy());
        strategyMap.put(FruitTransaction.Operation.RETURN, new ReturnStrategy());
    }

    public FruitStorage processTransactions(FruitTransactionStorage transactions) {
        FruitStorage fruitStorage = new FruitStorage();

        for (FruitTransaction transaction : transactions.getFruitTransactionList()) {
            TransactionStrategy strategy = strategyMap.get(transaction.getOperation());
            if (strategy != null) {
                strategy.apply(fruitStorage, transaction);
            }
        }

        return fruitStorage;
    }
}

